package com.apollo.hexagonal.application.core.usecase

import com.apollo.hexagonal.application.ports.`in`.DeleteCustomerByIdInputPort
import com.apollo.hexagonal.application.ports.`in`.FindCustomerByIdInputPort
import com.apollo.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort

class DeleteCustomerByIdUseCase(
    private val findCustomerByIdInputPort: FindCustomerByIdInputPort,
    private val deleteCustomerByIdOutputPort: DeleteCustomerByIdOutputPort
): DeleteCustomerByIdInputPort {

    override fun deleteById(id: String) {
        findCustomerByIdInputPort.find(id)
        deleteCustomerByIdOutputPort.delete(id)
    }
}