package com.apollo.hexagonal.application.ports.`in`

import com.apollo.hexagonal.application.core.domain.Customer

interface UpdateCustomerInputPort {

    fun update(customer: Customer, zipCode: String)
}