package io.deliveredkorea.b2b.sample.b2bsample

import io.deliveredkorea.b2b.sample.b2bsample.mapper.customer.dto.CustomerResponse
import io.deliveredkorea.b2b.sample.b2bsample.mapper.customer.dto.NewCustomerRequest
import org.assertj.core.api.Assertions

object TestCustomerUtil {
  fun checkSameCustomer(
    customerDTO: CustomerResponse,
    newCustomerDTO: NewCustomerRequest
  ) {
    Assertions.assertThat(customerDTO.id).isNotNull
    Assertions.assertThat(customerDTO.email).isEqualTo(newCustomerDTO.email)
    Assertions.assertThat(customerDTO.name).isEqualTo(newCustomerDTO.name)
    Assertions.assertThat(customerDTO.phoneNumber).isEqualTo(newCustomerDTO.phoneNumber)
  }
}