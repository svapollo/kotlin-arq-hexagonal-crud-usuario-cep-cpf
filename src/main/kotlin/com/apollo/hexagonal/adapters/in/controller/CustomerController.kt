package com.apollo.hexagonal.adapters.`in`.controller

import com.apollo.hexagonal.adapters.`in`.controller.request.CustomerRequest
import com.apollo.hexagonal.adapters.`in`.controller.response.CustomerResponse
import com.apollo.hexagonal.application.core.domain.Customer
import com.apollo.hexagonal.application.ports.`in`.DeleteCustomerByIdInputPort
import com.apollo.hexagonal.application.ports.`in`.FindCustomerByIdInputPort
import com.apollo.hexagonal.application.ports.`in`.InsertCustomerInputPort
import com.apollo.hexagonal.application.ports.`in`.UpdateCustomerInputPort
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/customers")
class CustomerController(
    private val insertCustomerInputPort: InsertCustomerInputPort,
    private val findCustomerByIdInputPort: FindCustomerByIdInputPort,
    private val updateCustomerInputPort: UpdateCustomerInputPort,
    private val deleteCustomerByIdInputPort: DeleteCustomerByIdInputPort
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun insert(@Valid @RequestBody customerRequest: CustomerRequest) {
        with(customerRequest) {
            val customer = Customer(name = name, cpf = cpf)
            insertCustomerInputPort.insert(customer, zipCode)
        }
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun findById(@PathVariable id: String): CustomerResponse {
        val customer = findCustomerByIdInputPort.find(id)
        return CustomerResponse(customer)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(
        @PathVariable id: String,
        @Valid @RequestBody customerRequest: CustomerRequest
    ) {
        with(customerRequest) {
            val customer = Customer(id = id, name = name, cpf = cpf)
            updateCustomerInputPort.update(customer, zipCode)
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteById(@PathVariable id: String) {
        deleteCustomerByIdInputPort.deleteById(id)
    }

}