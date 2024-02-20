package io.deliveredkorea.b2b.sample.b2bsample.api.customer.controller

import io.deliveredkorea.b2b.sample.b2bsample.mapper.customer.dto.CustomerResponse
import io.deliveredkorea.b2b.sample.b2bsample.mapper.customer.dto.NewCustomerRequest
import io.deliveredkorea.b2b.sample.b2bsample.core.customer.service.CustomerService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/customers")
class CustomerController(
  val customerService: CustomerService
) {
  @GetMapping
  fun getCustomers(): List<CustomerResponse> = customerService
    .getAll()

  @GetMapping("/{id}")
  fun getCustomer(
    @PathVariable id: Long
  ): CustomerResponse = customerService.get(id)

  @PostMapping
  fun createCustomer(
    @RequestBody @Valid newCustomerDTO: NewCustomerRequest
  ): CustomerResponse = customerService.create(newCustomerDTO)

}