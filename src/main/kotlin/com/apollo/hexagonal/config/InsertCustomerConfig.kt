package com.apollo.hexagonal.config

import com.apollo.hexagonal.adapters.out.FindAddressByZipCodeAdapter
import com.apollo.hexagonal.adapters.out.InsertCustomerAdapter
import com.apollo.hexagonal.adapters.out.SendCpfForValidationAdapter
import com.apollo.hexagonal.application.core.usecase.InsertCustomerUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class InsertCustomerConfig {

    @Bean
    fun insertCustomer(
        findAddressByZipCodeAdapter: FindAddressByZipCodeAdapter,
        insertCustomerAdapter: InsertCustomerAdapter,
        sendCpfForValidationAdapter: SendCpfForValidationAdapter
    ) = InsertCustomerUseCase(
        findAddressByZipCodeAdapter,
        insertCustomerAdapter,
        sendCpfForValidationAdapter
    )

}