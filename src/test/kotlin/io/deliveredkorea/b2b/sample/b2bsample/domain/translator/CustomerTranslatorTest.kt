package io.deliveredkorea.b2b.sample.b2bsample.domain.translator

import io.deliveredkorea.b2b.sample.b2bsample.mapper.customer.dto.NewCustomerRequest
import io.deliveredkorea.b2b.sample.b2bsample.infrastructure.database.customer.entity.Customer
import io.deliveredkorea.b2b.sample.b2bsample.mapper.customer.CustomerTranslator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CustomerTranslatorTest {
  @Test
  fun testToCustomer() {
    val newCustomerDTO = NewCustomerRequest(
      email = "kkum04@naver.com",
      name = "Ken Park",
      phoneNumber = "01037529304"
    )

    val customer = CustomerTranslator.toCustomer(newCustomerDTO)
    assertThat(customer).isNotNull
    assertThat(customer.id).isNull()
    assertThat(customer.name).isEqualTo(newCustomerDTO.name)
    assertThat(customer.email).isEqualTo(newCustomerDTO.email)
    assertThat(customer.phoneNumber).isEqualTo(newCustomerDTO.phoneNumber)
  }

  @Test
  fun testToCustomerDTO() {
    val customer = Customer(
      email = "kkum04@naver.com",
      name = "Ken Park",
      phoneNumber = "01037529304",
      id = 1
    )

    val customerDTO = CustomerTranslator.toCustomerDTO(customer)
    assertThat(customerDTO).isNotNull
    assertThat(customerDTO.id).isEqualTo(customer.id)
    assertThat(customerDTO.email).isEqualTo(customer.email)
    assertThat(customerDTO.name).isEqualTo(customer.name)
    assertThat(customerDTO.phoneNumber).isEqualTo(customer.phoneNumber)
  }
}