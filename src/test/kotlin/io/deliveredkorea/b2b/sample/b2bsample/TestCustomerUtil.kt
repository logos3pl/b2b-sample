package io.deliveredkorea.b2b.sample.b2bsample

import io.deliveredkorea.b2b.sample.b2bsample.domain.dto.CustomerDTO
import io.deliveredkorea.b2b.sample.b2bsample.domain.dto.NewCustomerDTO
import io.deliveredkorea.b2b.sample.b2bsample.domain.entity.Customer
import org.assertj.core.api.Assertions

object TestCustomerUtil {
  fun checkSameCustomer(
    customerDTO: CustomerDTO,
    newCustomerDTO: NewCustomerDTO
  ) {
    Assertions.assertThat(customerDTO.id).isNotNull
    Assertions.assertThat(customerDTO.email).isEqualTo(newCustomerDTO.email)
    Assertions.assertThat(customerDTO.name).isEqualTo(newCustomerDTO.name)
    Assertions.assertThat(customerDTO.phoneNumber).isEqualTo(newCustomerDTO.phoneNumber)
  }
}