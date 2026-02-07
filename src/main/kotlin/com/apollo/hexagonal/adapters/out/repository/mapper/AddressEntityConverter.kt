package com.apollo.hexagonal.adapters.out.repository.mapper

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter
import com.apollo.hexagonal.adapters.out.repository.entity.AddressEntity
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

class AddressEntityMapper : DynamoDBTypeConverter<String, AddressEntity> {
    private val objectMapper = jacksonObjectMapper()

    override fun convert(address: AddressEntity): String {
        return objectMapper.writeValueAsString(address)
    }

    override fun unconvert(json: String): AddressEntity {
        return objectMapper.readValue(json, AddressEntity::class.java)
    }
}