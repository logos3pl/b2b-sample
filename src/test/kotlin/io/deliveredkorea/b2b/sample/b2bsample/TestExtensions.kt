package io.deliveredkorea.b2b.sample.b2bsample

import jakarta.validation.Validator

fun <T> Validator.getDTOErrorCount(
  dto: T,
  propertyPath: String
): Int = this
  .validate(dto)
  .filter { it.propertyPath.toString() == propertyPath }
  .size