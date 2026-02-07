package com.apollo.hexagonal.config

import com.amazonaws.client.builder.AwsClientBuilder
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DynamoDBConfig {

    @Value("\${aws.dynamodb.endpoint}")
    private lateinit var dynamoDbEndpoint: String

    @Value("\${aws.dynamodb.region}")
    private lateinit var dynamoDbRegion: String

    @Bean
    fun amazonDynamoDB(): AmazonDynamoDB {
        return AmazonDynamoDBClientBuilder.standard()
            .withEndpointConfiguration(
                AwsClientBuilder.EndpointConfiguration(dynamoDbEndpoint, dynamoDbRegion)
            )
            .build()
    }

    @Bean
    fun dynamoDBMapper(amazonDynamoDB: AmazonDynamoDB) =
        DynamoDBMapper(amazonDynamoDB)
}