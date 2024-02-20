package io.deliveredkorea.b2b.sample.b2bsample.infrastructure.database.customer.repository

import io.deliveredkorea.b2b.sample.b2bsample.infrastructure.database.customer.entity.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository : JpaRepository<Customer, Long> {
}