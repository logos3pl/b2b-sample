package io.deliveredkorea.b2b.sample.b2bsample.repository

import io.deliveredkorea.b2b.sample.b2bsample.domain.entity.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository : JpaRepository<Customer, Long> {
}