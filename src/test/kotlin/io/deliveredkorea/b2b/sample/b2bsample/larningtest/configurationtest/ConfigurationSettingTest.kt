package io.deliveredkorea.b2b.sample.b2bsample.larningtest.configurationtest

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig

@SpringJUnitConfig
@ContextConfiguration(classes = [ConfigurationSetting::class])
class ConfigurationSettingTest {
  @Autowired
  lateinit var applicationContext: ApplicationContext

  @Test
  fun testContextLoad() {
    println("do nothing")
  }

  @Test
  fun test1() {
    println("application context: $applicationContext");
    println("this: $this");
  }

  @Test
  fun test2() {
    println("application context: $applicationContext");
    println("this: $this");
  }
}