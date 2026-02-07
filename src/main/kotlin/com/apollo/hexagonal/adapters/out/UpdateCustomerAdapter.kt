package com.apollo.hexagonal.adapters.out

import com.apollo.hexagonal.adapters.out.repository.CustomerRepository
import com.apollo.hexagonal.adapters.out.repository.entity.CustomerEntity
import com.apollo.hexagonal.application.core.domain.Customer
import com.apollo.hexagonal.application.ports.out.UpdateCustomerOutputPort
import org.springframework.stereotype.Component

@Component
class UpdateCustomerAdapter(
    private val customerRepository: CustomerRepository,
): UpdateCustomerOutputPort {

    override fun update(customer: Customer) {
        customerRepository.save(CustomerEntity(customer))
    }
}