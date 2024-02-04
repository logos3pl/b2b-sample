package io.deliveredkorea.b2b.sample.b2bsample.controller

import io.deliveredkorea.b2b.sample.b2bsample.domain.dto.NewCustomerDTO
import io.deliveredkorea.b2b.sample.b2bsample.getDTOErrorCount
import jakarta.validation.Validator
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class CustomerControllerValidationTest {
  @Autowired
  lateinit var validator: Validator

  @Test
  @DisplayName("NewCustomerDTO Validation Test")
  fun testValidationOfNewCustomerDTO() {
    val newCustomerDTO = NewCustomerDTO(
      email = null,
      name = null,
      phoneNumber = null
    )

    assertThat(validator.getDTOErrorCount(newCustomerDTO, "email")).isNotZero()
    assertThat(validator.getDTOErrorCount(newCustomerDTO.copy(email = ""), "email")).isNotZero()
    assertThat(validator.getDTOErrorCount(newCustomerDTO.copy(email = "  "), "email")).isNotZero()
    assertThat(validator.getDTOErrorCount(newCustomerDTO.copy(email = "Ken Park"), "email")).isNotZero()
    assertThat(validator.getDTOErrorCount(newCustomerDTO.copy(email = "1@aa"), "email")).isZero()
    assertThat(validator.getDTOErrorCount(newCustomerDTO.copy(email = "1@aa.com"), "email")).isZero()

    assertThat(validator.getDTOErrorCount(newCustomerDTO, "name")).isNotZero()
    assertThat(validator.getDTOErrorCount(newCustomerDTO.copy(name = ""), "name")).isNotZero()
    assertThat(validator.getDTOErrorCount(newCustomerDTO.copy(name = "  "), "name")).isNotZero()
    assertThat(validator.getDTOErrorCount(newCustomerDTO.copy(name = "Ken"), "name")).isZero()

    assertThat(validator.getDTOErrorCount(newCustomerDTO, "phoneNumber")).isZero()
    assertThat(validator.getDTOErrorCount(newCustomerDTO.copy(phoneNumber = "01037529304"), "phoneNumber")).isZero()
  }
}