package com.apollo.hexagonal.application.ports.out

import com.apollo.hexagonal.application.core.domain.Address

interface FindAddressByZipCodeOutputPort {

    fun find(zipCode: String): Address
}