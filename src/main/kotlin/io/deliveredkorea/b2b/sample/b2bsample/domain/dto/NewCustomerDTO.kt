package io.deliveredkorea.b2b.sample.b2bsample.domain.dto

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import io.deliveredkorea.b2b.sample.b2bsample.domain.entity.Customer
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import org.jetbrains.annotations.NotNull


@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class NewCustomerDTO(
  @field:NotBlank
  @field:Email
  val email: String?,
  @field:NotBlank
  val name: String?,
  val phoneNumber: String?
)