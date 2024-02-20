package io.deliveredkorea.b2b.sample.b2bsample.core.customer.service

import io.deliveredkorea.b2b.sample.b2bsample.mapper.customer.dto.CustomerResponse
import io.deliveredkorea.b2b.sample.b2bsample.mapper.customer.dto.NewCustomerRequest
import io.deliveredkorea.b2b.sample.b2bsample.mapper.customer.CustomerTranslator
import io.deliveredkorea.b2b.sample.b2bsample.infrastructure.database.customer.repository.CustomerRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class CustomerServiceImpl(
  private val customerRepository: CustomerRepository,
) : CustomerService {
  override fun getAll(): List<CustomerResponse> = customerRepository
    .findAll()
    .map(CustomerTranslator::toCustomerDTO)

  @Throws(ResponseStatusException::class)
  override fun get(id: Long): CustomerResponse = customerRepository
    .findByIdOrNull(id)
    ?.let(CustomerTranslator::toCustomerDTO)
    ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)

  override fun create(
    newCustomerDTO: NewCustomerRequest
  ): CustomerResponse = CustomerTranslator
    .toCustomer(newCustomerDTO)
    .let(customerRepository::save)
    .let(CustomerTranslator::toCustomerDTO)
}