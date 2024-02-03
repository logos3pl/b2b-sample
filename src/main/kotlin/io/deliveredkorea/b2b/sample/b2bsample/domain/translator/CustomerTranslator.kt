package io.deliveredkorea.b2b.sample.b2bsample.domain.translator

import io.deliveredkorea.b2b.sample.b2bsample.domain.dto.CustomerDTO
import io.deliveredkorea.b2b.sample.b2bsample.domain.entity.Customer

object CustomerTranslator {
  fun toCustomerDTO(customer: Customer) = CustomerDTO(
    id = customer.id!!,
    email = customer.email,
    name = customer.name,
    phoneNumber = customer.phoneNumber
  )
}