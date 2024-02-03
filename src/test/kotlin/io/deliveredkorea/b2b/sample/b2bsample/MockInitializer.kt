package io.deliveredkorea.b2b.sample.b2bsample

import io.deliveredkorea.b2b.sample.b2bsample.domain.entity.Customer
import io.deliveredkorea.b2b.sample.b2bsample.repository.CustomerRepository
import org.mockito.Mockito
import org.springframework.data.repository.findByIdOrNull
import java.util.*

object MockInitializer {
  private val customers: MutableList<Customer> = mutableListOf()

  fun createCustomerRepository(): CustomerRepository {
    val repository = Mockito.mock(CustomerRepository::class.java)
    customers.clear()

    // findAll
    Mockito.`when`(repository.findAll()).then { customers }

    // findIdOrNull
    Mockito.`when`(repository.findByIdOrNull(Mockito.anyLong())).thenAnswer {
      val id = it.getArgument<Long>(0)

      customers.firstOrNull { it.id == id }
        ?.let { Optional.of(it) }
        ?: Optional.empty<Customer>()
    }

    // save
    Mockito.`when`(repository.save(Mockito.any(Customer::class.java))).thenAnswer {
      val new = it.getArgument<Customer>(0)

      customers.firstOrNull {it.id == new.id}
        ?.let { updateCustomer(it, new) }
        ?: createNewCustomer(new)
    }

    return repository
  }

  private fun updateCustomer(old: Customer, new: Customer): Customer {
    old.email = new.email
    old.name = new.name
    old.phoneNumber = new.phoneNumber
    return old
  }

  private fun createNewCustomer(customer: Customer): Customer {
    customer.id = customers.maxByOrNull { it.id!! }?.let(Customer::id)?.let(Long::inc) ?: 0
    customers.add(customer)
    return customer
  }
}