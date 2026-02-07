package com.apollo.hexagonal.config

import com.apollo.hexagonal.adapters.out.FindCustomerByIdAdapter
import com.apollo.hexagonal.application.core.usecase.FindCustomerByIdUseCase
import com.apollo.hexagonal.application.ports.`in`.FindCustomerByIdInputPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FindCustomerByIdConfig {

    @Bean
    fun findCustomerByID(findCustomerByIdAdapter: FindCustomerByIdAdapter) =
        FindCustomerByIdUseCase(findCustomerByIdAdapter)
}