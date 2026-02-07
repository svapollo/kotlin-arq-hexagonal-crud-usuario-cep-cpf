package com.apollo.hexagonal.adapters.`in`.consumer.message

import com.apollo.hexagonal.application.core.domain.Customer

data class CustomerMessage(
    val id: String,
    val name: String,
    val zipCode: String,
    val cpf: String,
    val isValidCpf: Boolean
) {
    fun toCustomer() = Customer(
        id = this.id,
        name = this.name,
        cpf = this.cpf,
        isValidCpf = this.isValidCpf
    )
}