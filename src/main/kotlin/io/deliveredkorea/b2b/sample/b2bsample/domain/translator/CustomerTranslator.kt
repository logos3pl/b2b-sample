package io.deliveredkorea.b2b.sample.b2bsample.domain.translator

import io.deliveredkorea.b2b.sample.b2bsample.domain.dto.CustomerDTO
import io.deliveredkorea.b2b.sample.b2bsample.domain.dto.NewCustomerDTO
import io.deliveredkorea.b2b.sample.b2bsample.domain.entity.Customer

object CustomerTranslator {
  fun toCustomer(newCustomerDTO: NewCustomerDTO) = Customer(
    newCustomerDTO.email!!,
    newCustomerDTO.name!!,
    newCustomerDTO.phoneNumber,
  )

  fun toCustomerDTO(customer: Customer) = CustomerDTO(
    id = customer.id!!,
    email = customer.email,
    name = customer.name,
    phoneNumber = customer.phoneNumber
  )
}