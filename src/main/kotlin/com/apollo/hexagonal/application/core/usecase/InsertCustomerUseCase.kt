package com.apollo.hexagonal.application.core.usecase

import com.apollo.hexagonal.application.core.domain.Customer
import com.apollo.hexagonal.application.ports.`in`.InsertCustomerInputPort
import com.apollo.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort
import com.apollo.hexagonal.application.ports.out.InsertCustomerOutputPort
import com.apollo.hexagonal.application.ports.out.SendCpfForValidationOutputPort

class InsertCustomerUseCase(
    private val findAddressByZipCodeOutputPort: FindAddressByZipCodeOutputPort,
    private val insertCustomerOutputPort: InsertCustomerOutputPort,
    private val sendCpfForValidationOutputPort: SendCpfForValidationOutputPort
): InsertCustomerInputPort {

    override fun insert(customer: Customer, zipCode: String) {
        customer.apply {
            address = findAddressByZipCodeOutputPort.find(zipCode)
        }.let {
            insertCustomerOutputPort.insert(it)
            sendCpfForValidationOutputPort.send(it.cpf)
        }

    }
}