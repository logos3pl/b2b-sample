package io.deliveredkorea.b2b.sample.b2bsample.service

import io.deliveredkorea.b2b.sample.b2bsample.MockInitializer
import io.deliveredkorea.b2b.sample.b2bsample.TestCustomerUtil.checkSameCustomer
import io.deliveredkorea.b2b.sample.b2bsample.core.customer.service.CustomerService
import io.deliveredkorea.b2b.sample.b2bsample.core.customer.service.CustomerServiceImpl
import io.deliveredkorea.b2b.sample.b2bsample.mapper.customer.dto.NewCustomerRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.web.server.ResponseStatusException

class CustomerServiceTestWithoutSpring {
  lateinit var customerService: CustomerService

  @Test
  fun testGetAll() {
    assertThat(customerService.getAll()).isEmpty()

    val newDTO = NewCustomerRequest(
      "kkum04@gmail.com",
      "박태환",
      "01037529304"
    )
    customerService.create(newDTO)
    val customers = customerService.getAll()
    assertThat(customers.size).isEqualTo(1)
    checkSameCustomer(customers[0], newDTO)


    val newDTO2 = newDTO.copy(email = "kkum04@naver.com")
    customerService.create(newDTO2)
    val customers2 = customerService.getAll()
    assertThat(customers2.size).isEqualTo(2)
    checkSameCustomer(customers2[1], newDTO2)
  }

  @Test
  fun testGetCustomer() {
    val newCustomerDTO = NewCustomerRequest(
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
    val newCustomerDTO = NewCustomerRequest(
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

  @BeforeEach
  fun initialize() {
    customerService = CustomerServiceImpl(
      customerRepository = MockInitializer.createCustomerRepository()
    )
  }
}