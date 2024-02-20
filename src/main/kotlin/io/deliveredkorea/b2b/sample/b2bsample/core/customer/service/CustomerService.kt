package io.deliveredkorea.b2b.sample.b2bsample.core.customer.service

import io.deliveredkorea.b2b.sample.b2bsample.mapper.customer.dto.CustomerResponse
import io.deliveredkorea.b2b.sample.b2bsample.mapper.customer.dto.NewCustomerRequest
import org.springframework.web.server.ResponseStatusException

interface CustomerService {
  fun getAll(): List<CustomerResponse>

  @Throws(ResponseStatusException::class)
  fun get(id: Long): CustomerResponse

  fun create(newCustomerDTO: NewCustomerRequest): CustomerResponse
}