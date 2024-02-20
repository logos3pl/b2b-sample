package io.deliveredkorea.b2b.sample.b2bsample.mapper.customer.vo

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming


@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class CustomerVO(
  val id: Long,
  val email: String,
  val name: String,
  val phoneNumber: String?
)