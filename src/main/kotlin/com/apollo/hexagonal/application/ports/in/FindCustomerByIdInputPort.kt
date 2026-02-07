package com.apollo.hexagonal.application.ports.`in`

import com.apollo.hexagonal.application.core.domain.Customer

interface FindCustomerByIdInputPort {

    fun find(id: String): Customer
}