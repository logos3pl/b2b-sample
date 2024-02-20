package io.deliveredkorea.b2b.sample.b2bsample.larningtest.springboottest

import io.deliveredkorea.b2b.sample.b2bsample.core.customer.service.CustomerService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.DirtiesContext

@SpringBootTest
class SpringBootTestConfiguration {
  @Autowired
  lateinit var customerService: CustomerService

  @Test
  @DirtiesContext
  fun test1() {
    println("customer service: $customerService");
    println("this: $this");
  }

  @Test
  fun test2() {
    println("customer service: $customerService");
    println("this: $this");
  }

  @Test
  fun test3() {
    println("customer service: $customerService");
    println("this: $this");
  }
}