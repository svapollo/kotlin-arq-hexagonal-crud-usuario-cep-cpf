package com.apollo.hexagonal.application.core.usecase

import com.apollo.hexagonal.application.core.domain.Customer
import com.apollo.hexagonal.application.core.exceptions.ObjectNotFoundException
import com.apollo.hexagonal.application.ports.`in`.FindCustomerByIdInputPort
import com.apollo.hexagonal.application.ports.out.FindCustomerByIdOutputPort

class FindCustomerByIdUseCase(
    private val findCustomerByIdOutputPort: FindCustomerByIdOutputPort
): FindCustomerByIdInputPort {

    override fun find(id: String) =
        findCustomerByIdOutputPort.find(id) ?: throw ObjectNotFoundException(
            "Customer not found")
}