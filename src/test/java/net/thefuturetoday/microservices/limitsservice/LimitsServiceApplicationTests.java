package net.thefuturetoday.microservices.limitsservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class LimitsServiceApplicationTests {

	@Autowired
	private LimitsConfigurationController controller;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
