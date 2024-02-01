package io.deliveredkorea.b2b.sample.b2bsample.controller

import io.deliveredkorea.b2b.sample.b2bsample.domain.dto.CustomerDTO
import io.deliveredkorea.b2b.sample.b2bsample.domain.dto.NewCustomerDTO
import io.deliveredkorea.b2b.sample.b2bsample.service.CustomerService
import io.deliveredkorea.b2b.sample.b2bsample.service.CustomerServiceImpl
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
  fun getCustomers(): List<CustomerDTO> = customerService
    .getAll()

  @GetMapping("/{id}")
  fun getCustomer(
    @PathVariable id: Long
  ): CustomerDTO = customerService.get(id)

  @PostMapping
  fun createCustomer(
    @RequestBody @Valid newCustomerDTO: NewCustomerDTO
  ): CustomerDTO = customerService.create(newCustomerDTO)

}