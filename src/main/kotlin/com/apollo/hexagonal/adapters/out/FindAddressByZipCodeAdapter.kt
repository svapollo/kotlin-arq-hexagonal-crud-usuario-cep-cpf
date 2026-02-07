package com.apollo.hexagonal.adapters.out

import com.apollo.hexagonal.adapters.out.client.FindAddressByZipCodeClient
import com.apollo.hexagonal.application.core.domain.Address
import com.apollo.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort
import org.springframework.stereotype.Component

@Component
class FindAddressByZipCodeAdapter(
    private val findAddressByZipCodeClient: FindAddressByZipCodeClient
): FindAddressByZipCodeOutputPort {

    override fun find(zipCode: String): Address =
        findAddressByZipCodeClient.find(zipCode).toAddress()

}