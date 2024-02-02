package io.deliveredkorea.b2b.sample.b2bsample.service

import io.deliveredkorea.b2b.sample.b2bsample.domain.dto.CustomerDTO
import io.deliveredkorea.b2b.sample.b2bsample.domain.dto.NewCustomerDTO
import io.deliveredkorea.b2b.sample.b2bsample.domain.entity.Customer
import io.deliveredkorea.b2b.sample.b2bsample.repository.CustomerRepository
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class CustomerServiceImpl(
  val customerRepository: CustomerRepository
) : CustomerService {
  override fun getAll(): List<CustomerDTO> = customerRepository
    .findAll()
    .map(CustomerDTO::create)

  @Throws(ResponseStatusException::class)
  override fun get(id: Long): CustomerDTO = customerRepository
    .findById(id)
    .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND) }
    .let(CustomerDTO::create)

  override fun create(
    newCustomerDTO: NewCustomerDTO
  ): CustomerDTO = Customer(
    newCustomerDTO.email!!,
    newCustomerDTO.name!!,
    newCustomerDTO.phoneNumber,
    0
  )
    //.let(Customer::create)
    .let(customerRepository::save)
    .let(CustomerDTO::create)
}