package com.example.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class HelloControllerTest {

  @Test
  void contextLoads() {
    HelloController controller = new HelloController();
    assertThat(controller.hello()).isEqualTo("Hello from Spring Boot with CI/CD!");
  }
}