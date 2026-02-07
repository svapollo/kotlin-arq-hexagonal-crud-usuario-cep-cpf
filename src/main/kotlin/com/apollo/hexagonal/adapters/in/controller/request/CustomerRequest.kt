package com.apollo.hexagonal.adapters.`in`.controller.request

import jakarta.validation.constraints.NotBlank

data class CustomerRequest(

    @field:NotBlank(message = "Name cannot be blank")
    val name: String,

    @field:NotBlank(message = "CPF cannot be blank")
    val cpf: String,

    @field:NotBlank(message = "Zip Code cannot be blank")
    val zipCode: String
)
