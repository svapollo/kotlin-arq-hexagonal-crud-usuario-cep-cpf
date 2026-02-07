package com.apollo.hexagonal.config

import com.apollo.hexagonal.adapters.`in`.consumer.message.CustomerMessage
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import org.apache.kafka.clients.consumer.ConsumerConfig.AUTO_OFFSET_RESET_CONFIG
import org.apache.kafka.clients.consumer.ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG
import org.apache.kafka.clients.consumer.ConsumerConfig.GROUP_ID_CONFIG
import org.apache.kafka.clients.consumer.ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG
import org.apache.kafka.clients.consumer.ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.support.serializer.JsonDeserializer

@EnableKafka
@Configuration
class KafkaConsumerConfig {

    private val configProps = mapOf(
        BOOTSTRAP_SERVERS_CONFIG to "localhost:9092",
        GROUP_ID_CONFIG to "apollo",
        KEY_DESERIALIZER_CLASS_CONFIG to StringDeserializer::class.java,
        VALUE_DESERIALIZER_CLASS_CONFIG to JsonDeserialize::class.java,
        AUTO_OFFSET_RESET_CONFIG to "earliest"
    )

    @Bean
    fun consumerFactory(): ConsumerFactory<String, CustomerMessage> =
        DefaultKafkaConsumerFactory(configProps, StringDeserializer(), JsonDeserializer(CustomerMessage::class.java))

    @Bean
    fun kafkaListenerContainerFactory():
            ConcurrentKafkaListenerContainerFactory<String, CustomerMessage> =
        ConcurrentKafkaListenerContainerFactory<String, CustomerMessage>().apply {
            consumerFactory = consumerFactory()
        }
}