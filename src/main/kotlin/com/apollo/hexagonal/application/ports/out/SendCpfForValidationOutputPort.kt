package com.apollo.hexagonal.application.ports.out

interface SendCpfForValidationOutputPort {

    fun send(cpf: String)
}