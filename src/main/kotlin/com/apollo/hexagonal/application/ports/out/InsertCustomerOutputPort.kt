package com.apollo.hexagonal.application.ports.out

import com.apollo.hexagonal.application.core.domain.Customer

interface InsertCustomerOutputPort {

    fun insert(customer: Customer)
}