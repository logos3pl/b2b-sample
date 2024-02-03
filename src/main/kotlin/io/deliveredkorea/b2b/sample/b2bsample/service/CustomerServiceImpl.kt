package io.deliveredkorea.b2b.sample.b2bsample.service

import io.deliveredkorea.b2b.sample.b2bsample.domain.dto.CustomerDTO
import io.deliveredkorea.b2b.sample.b2bsample.domain.dto.NewCustomerDTO
import io.deliveredkorea.b2b.sample.b2bsample.domain.entity.Customer
import io.deliveredkorea.b2b.sample.b2bsample.domain.translator.CustomerTranslator
import io.deliveredkorea.b2b.sample.b2bsample.repository.CustomerRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class CustomerServiceImpl(
  val customerRepository: CustomerRepository,
) : CustomerService {
  override fun getAll(): List<CustomerDTO> = customerRepository
    .findAll()
    .map(CustomerTranslator::toCustomerDTO)

  @Throws(ResponseStatusException::class)
  override fun get(id: Long): CustomerDTO = customerRepository
    .findByIdOrNull(id)
    ?.let(CustomerTranslator::toCustomerDTO)
    ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)

  override fun create(
    newCustomerDTO: NewCustomerDTO
  ): CustomerDTO = Customer(
    newCustomerDTO.email!!,
    newCustomerDTO.name!!,
    newCustomerDTO.phoneNumber,
  )
    .let(customerRepository::save)
    .let(CustomerTranslator::toCustomerDTO)
}