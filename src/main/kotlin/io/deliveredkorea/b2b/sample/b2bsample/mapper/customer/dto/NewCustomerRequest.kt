package io.deliveredkorea.b2b.sample.b2bsample.mapper.customer.dto

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class NewCustomerRequest(
  @field:NotBlank
  @field:Email
  val email: String?,
  @field:NotBlank
  val name: String?,
  val phoneNumber: String?
)