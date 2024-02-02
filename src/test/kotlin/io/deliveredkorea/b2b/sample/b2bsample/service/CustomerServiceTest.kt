package io.deliveredkorea.b2b.sample.b2bsample.service

import io.deliveredkorea.b2b.sample.b2bsample.domain.dto.CustomerDTO
import io.deliveredkorea.b2b.sample.b2bsample.domain.dto.NewCustomerDTO
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.web.server.ResponseStatusException

@SpringBootTest
class CustomerServiceTest {
  @Autowired
  lateinit var customerService: CustomerService

  @Test
  fun testGetCustomer() {
    val newCustomerDTO = NewCustomerDTO(
      "kkum04@gmail.com",
      "박태환",
      "01037529304"
    )

    val customer = customerService.create(newCustomerDTO)
    assertThat(customer).isNotNull
    checkSameCustomer(customer, newCustomerDTO)

    assertThrows<ResponseStatusException> {
      customerService.get(-1)
    }
  }

  @Test
  fun testCreateCustomer() {
    val newCustomerDTO = NewCustomerDTO(
      "kkum04@gmail.com",
      "박태환",
      "01037529304"
    )

    val customer = customerService.create(newCustomerDTO)
    assertThat(customer).isNotNull
    checkSameCustomer(customer, newCustomerDTO)

    val foundCustomer = customerService.get(customer.id)
    checkSameCustomer(foundCustomer, newCustomerDTO)
  }

  fun checkSameCustomer(
    customerDTO: CustomerDTO,
    newCustomerDTO: NewCustomerDTO
  ) {
    assertThat(customerDTO.id).isNotNull
    assertThat(customerDTO.email).isEqualTo(newCustomerDTO.email)
    assertThat(customerDTO.name).isEqualTo(newCustomerDTO.name)
    assertThat(customerDTO.phoneNumber).isEqualTo(newCustomerDTO.phoneNumber)
  }
}