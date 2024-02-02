package io.deliveredkorea.b2b.sample.b2bsample.repository

import io.deliveredkorea.b2b.sample.b2bsample.domain.entity.Customer
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.data.repository.findByIdOrNull

@DataJpaTest
class CustomerRepositoryTest {
  @Autowired
  lateinit var customerRepository: CustomerRepository

  @Test
  @DisplayName("Database에서 Entity로의 매핑 확인")
  fun testFind() {
    customerRepository.save(customer1)

    assertThat(customerRepository.findByIdOrNull(customer1.id)).isNotNull
    assertThat(customerRepository.findByIdOrNull(-1)).isNull()
  }

  @Test
  @DisplayName("Entity에서 Database로의 저장 확인")
  fun testCreate() {
    assertDoesNotThrow {
      customerRepository.save(customer1)
    }

    assertThrows<DataIntegrityViolationException> {
      customer2.name = "100글자 넘음!!100글자 넘음!!100글자 넘음!!100글자 넘음!!100글자 넘음!!100글자 넘음!!100글자 넘음!!100글자 넘음!!100글자 넘음!!100글자 넘음!!@"
      customerRepository.save(customer2)
    }
  }

  @Test
  fun testFindAll() {
    val emptyCustomers = customerRepository.findAll()
    assertThat(emptyCustomers.size).isEqualTo(0)

    customerRepository.save(customer1)
    customerRepository.save(customer2)

    val foundCustomers = customerRepository.findAll()

    assertThat(foundCustomers.size).isEqualTo(2)
    assertThat(foundCustomers[0].email).isEqualTo("kkum04@gmail.com")
  }

  val customer1 = Customer(
    id = 0,
    email = "kkum04@gmail.com",
    name = "Ken Park",
    phoneNumber = "01037529304"
  )

  val customer2 = Customer(
    id = 0,
    email = "ken@delivered.co.kr",
    name = "Ken Park2",
    phoneNumber = null
  )
}