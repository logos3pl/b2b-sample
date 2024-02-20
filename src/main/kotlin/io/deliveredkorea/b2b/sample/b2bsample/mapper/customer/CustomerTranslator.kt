package io.deliveredkorea.b2b.sample.b2bsample.mapper.customer

import io.deliveredkorea.b2b.sample.b2bsample.mapper.customer.dto.CustomerResponse
import io.deliveredkorea.b2b.sample.b2bsample.mapper.customer.dto.NewCustomerRequest
import io.deliveredkorea.b2b.sample.b2bsample.infrastructure.database.customer.entity.Customer

object CustomerTranslator {
  fun toCustomer(newCustomerDTO: NewCustomerRequest) = Customer(
    newCustomerDTO.email!!,
    newCustomerDTO.name!!,
    newCustomerDTO.phoneNumber,
  )

  fun toCustomerDTO(customer: Customer) = CustomerResponse(
    id = customer.id!!,
    email = customer.email,
    name = customer.name,
    phoneNumber = customer.phoneNumber
  )
}