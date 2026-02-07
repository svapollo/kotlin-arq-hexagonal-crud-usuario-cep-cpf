package com.apollo.hexagonal.adapters.out.repository.entity

import com.apollo.hexagonal.application.core.domain.Address

data class AddressEntity(
    val street: String,
    val city: String,
    val state: String
) {
    constructor(address: Address): this(
        address.street,
        address.city,
        address.state
    )

    fun toAddress() = Address(
        street,
        city,
        state
    )
}
