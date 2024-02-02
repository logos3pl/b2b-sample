package io.deliveredkorea.b2b.sample.b2bsample.domain.entity

import io.deliveredkorea.b2b.sample.b2bsample.domain.dto.NewCustomerDTO
import jakarta.persistence.*


@Entity
@Table(name = "customer")
class Customer(
  @Column(nullable = false, length = 100)
  val email: String,

  @Column(nullable = false, length = 100)
  val name: String,

  @Column
  val phoneNumber: String?,

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  val id: Long? = null,
) {
  companion object {
    fun create(newCustomerDTO: NewCustomerDTO) = Customer(
      id = 0,
      email = newCustomerDTO.email!!,
      name = newCustomerDTO.name!!,
      phoneNumber = newCustomerDTO.phoneNumber
    )
  }
}