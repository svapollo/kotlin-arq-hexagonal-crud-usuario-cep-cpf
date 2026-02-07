package com.apollo.hexagonal.application.ports.`in`

import com.apollo.hexagonal.application.core.domain.Customer

interface InsertCustomerInputPort {

    fun insert(customer: Customer, zipCode: String)
}