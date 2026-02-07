package com.apollo.hexagonal.application.ports.`in`

interface DeleteCustomerByIdInputPort {

    fun deleteById(id: String)
}