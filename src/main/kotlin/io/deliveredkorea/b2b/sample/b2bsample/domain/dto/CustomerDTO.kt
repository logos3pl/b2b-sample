package io.deliveredkorea.b2b.sample.b2bsample.domain.dto

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import io.deliveredkorea.b2b.sample.b2bsample.domain.entity.Customer


@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class CustomerDTO(
  val id: Long,
  val email: String,
  val name: String,
  val phoneNumber: String?
) {
  companion object {
    // or Translator?
    fun create(customer: Customer) = CustomerDTO(
      id = customer.id!!,
      email = customer.email,
      name = customer.name,
      phoneNumber = customer.phoneNumber
    )
  }
}