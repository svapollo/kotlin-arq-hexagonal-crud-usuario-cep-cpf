package com.apollo.hexagonal.adapters.out

import com.apollo.hexagonal.adapters.out.repository.CustomerRepository
import com.apollo.hexagonal.adapters.out.repository.entity.CustomerEntity
import com.apollo.hexagonal.application.core.domain.Customer
import com.apollo.hexagonal.application.ports.out.InsertCustomerOutputPort
import org.springframework.stereotype.Component

@Component
class InsertCustomerAdapter(
    private val customerRepository: CustomerRepository
): InsertCustomerOutputPort {

    override fun insert(customer: Customer) {
        customerRepository.save(CustomerEntity(customer))
    }
}