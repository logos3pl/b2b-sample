package io.deliveredkorea.b2b.sample.b2bsample.service

import io.deliveredkorea.b2b.sample.b2bsample.domain.dto.CustomerDTO
import io.deliveredkorea.b2b.sample.b2bsample.domain.dto.NewCustomerDTO
import org.springframework.web.server.ResponseStatusException

interface CustomerService {
  fun getAll(): List<CustomerDTO>

  @Throws(ResponseStatusException::class)
  fun get(id: Long): CustomerDTO

  fun create(newCustomerDTO: NewCustomerDTO): CustomerDTO
}