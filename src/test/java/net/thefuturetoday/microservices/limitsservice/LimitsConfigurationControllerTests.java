package net.thefuturetoday.microservices.limitsservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LimitsConfigurationControllerTests {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private Configuration configuration;

    @Test
    public void shouldReturnConfigurationFromPropertiesFile() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/limits",
                Configuration.class).equals(configuration));
    }
}
