package io.deliveredkorea.b2b.sample.b2bsample.mapper.customer.dto

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming


@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class CustomerResponse(
  val id: Long,
  val email: String,
  val name: String,
  val phoneNumber: String?
)