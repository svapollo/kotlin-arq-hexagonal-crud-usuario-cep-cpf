package com.apollo.hexagonal.config

import com.apollo.hexagonal.adapters.out.FindAddressByZipCodeAdapter
import com.apollo.hexagonal.adapters.out.SendCpfForValidationAdapter
import com.apollo.hexagonal.adapters.out.UpdateCustomerAdapter
import com.apollo.hexagonal.application.core.usecase.FindCustomerByIdUseCase
import com.apollo.hexagonal.application.core.usecase.UpdateCustomerUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UpdateCustomerConfig {

    @Bean
    fun updateCustomer(
        findCustomerByIdUseCase: FindCustomerByIdUseCase,
        findAddressByZipCodeAdapter: FindAddressByZipCodeAdapter,
        updateCustomerAdapter: UpdateCustomerAdapter,
        sendCpfForValidationAdapter: SendCpfForValidationAdapter
    ) = UpdateCustomerUseCase(
        findCustomerByIdUseCase,
        findAddressByZipCodeAdapter,
        updateCustomerAdapter,
        sendCpfForValidationAdapter
    )
}