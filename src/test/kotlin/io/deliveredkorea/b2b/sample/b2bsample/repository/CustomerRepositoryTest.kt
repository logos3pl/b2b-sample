package io.deliveredkorea.b2b.sample.b2bsample.repository

import io.deliveredkorea.b2b.sample.b2bsample.domain.entity.Customer
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
class CustomerRepositoryTest {
  @Autowired
  lateinit var customerRepository: CustomerRepository

  @Test
  fun testFindAll() {
    val foundCustomers = customerRepository.findAll()

    assertThat(foundCustomers.size).isEqualTo(2)
    assertThat(foundCustomers[0].email).isEqualTo("kkum04@gmail.com")
  }

  @BeforeEach
  fun initialize() {
    val customer = Customer(
      id = 0,
      email = "kkum04@gmail.com",
      name = "Ken Park",
      phoneNumber = "01037529304"
    )
    val customer1 = Customer(
      id = 0,
      email = "ken@delivered.co.kr",
      name = "Ken Park2",
      phoneNumber = null
    )

    customerRepository.save(customer)
    customerRepository.save(customer1)
  }

}