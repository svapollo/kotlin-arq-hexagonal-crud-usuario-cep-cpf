package com.apollo.hexagonal.adapters.out

import com.apollo.hexagonal.adapters.out.repository.CustomerRepository
import com.apollo.hexagonal.application.core.domain.Customer
import com.apollo.hexagonal.application.ports.out.FindCustomerByIdOutputPort
import org.springframework.stereotype.Component

@Component
class FindCustomerByIdAdapter(
    private val customerRepository: CustomerRepository
): FindCustomerByIdOutputPort {

    override fun find(id: String): Customer? =
        customerRepository.findById(id).let {
            return it?.toCustomer()
    }
}