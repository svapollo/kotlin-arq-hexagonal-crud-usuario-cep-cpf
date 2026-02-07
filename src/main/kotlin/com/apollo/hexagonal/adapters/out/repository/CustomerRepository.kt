package com.apollo.hexagonal.adapters.out.repository

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper
import com.apollo.hexagonal.adapters.out.repository.entity.CustomerEntity
import org.springframework.stereotype.Repository

@Repository
class CustomerRepository(
    private val dynamoDBMapper: DynamoDBMapper
) {

    fun save(customerEntity: CustomerEntity): CustomerEntity {
        dynamoDBMapper.save(customerEntity)
        return customerEntity
    }

    fun findById(id: String): CustomerEntity? {
        return dynamoDBMapper.load(CustomerEntity::class.java, id)
    }

    fun deleteById(id: String) {
        val customerEntity = CustomerEntity(id = id)
        dynamoDBMapper.delete(customerEntity)
    }
}