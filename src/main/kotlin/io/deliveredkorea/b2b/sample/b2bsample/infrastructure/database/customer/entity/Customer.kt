package io.deliveredkorea.b2b.sample.b2bsample.infrastructure.database.customer.entity

import jakarta.persistence.*


@Entity
@Table(name = "customer")
class Customer(
  @Column(nullable = false, length = 100)
  var email: String,

  @Column(nullable = false, length = 100)
  var name: String,

  @Column
  var phoneNumber: String?,

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  var id: Long? = null,
)