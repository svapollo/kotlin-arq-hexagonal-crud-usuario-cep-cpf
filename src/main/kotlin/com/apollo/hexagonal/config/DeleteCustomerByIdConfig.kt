package com.apollo.hexagonal.config

import com.apollo.hexagonal.adapters.out.DeleteCustomerByIdAdapter
import com.apollo.hexagonal.application.core.usecase.DeleteCustomerByIdUseCase
import com.apollo.hexagonal.application.core.usecase.FindCustomerByIdUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DeleteCustomerByIdConfig {

    @Bean
    fun deleteCustomerById(
        findCustomerByIdUseCase: FindCustomerByIdUseCase,
        deleteCustomerByIdAdapter: DeleteCustomerByIdAdapter
    ) = DeleteCustomerByIdUseCase(findCustomerByIdUseCase, deleteCustomerByIdAdapter)
}