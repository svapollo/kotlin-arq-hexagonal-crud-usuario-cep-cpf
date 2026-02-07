package com.apollo.hexagonal.application.core.usecase

import com.apollo.hexagonal.application.core.domain.Customer
import com.apollo.hexagonal.application.ports.`in`.FindCustomerByIdInputPort
import com.apollo.hexagonal.application.ports.`in`.UpdateCustomerInputPort
import com.apollo.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort
import com.apollo.hexagonal.application.ports.out.SendCpfForValidationOutputPort
import com.apollo.hexagonal.application.ports.out.UpdateCustomerOutputPort

class UpdateCustomerUseCase(
    private val findCustomerByIdInputPort: FindCustomerByIdInputPort,
    private val findAddressByZipCodeOutputPort: FindAddressByZipCodeOutputPort,
    private val updateCustomerOutputPort: UpdateCustomerOutputPort,
    private val sendCpfForValidationOutputPort: SendCpfForValidationOutputPort
): UpdateCustomerInputPort {

    override fun update(customer: Customer, zipCode: String) {
        if (customer.id == null) throw IllegalArgumentException(
            "Customer ID cannot be null.")
        val savedCpf = findCustomerByIdInputPort.find(customer.id).cpf

        customer.apply {
            address = findAddressByZipCodeOutputPort.find(zipCode)
        }.let {
            updateCustomerOutputPort.update(it)
            if (savedCpf != it.cpf) {
                sendCpfForValidationOutputPort.send(it.cpf)
            }
        }
    }
}