package net.thefuturetoday.microservices.limitsservice;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {
    private final Configuration configuration;

    public LimitsConfigurationController(Configuration configuration) {
        this.configuration = configuration;
    }

    @GetMapping("/limits")
    public LimitConfiguration retrieveLimitsFromConfiguration() {
        //getting values from the properties file
        return new LimitConfiguration(configuration.getMaximum(), configuration.getMinimum());
    }

    @GetMapping("/fault-tolerance-example")
    //configuring a fallback method
    @HystrixCommand(fallbackMethod="fallbackRetrieveConfigurations")
    public LimitConfiguration retrieveConfigurations()
    {
        throw new RuntimeException("Not Available");
    }

    //defining the fallback method
    public LimitConfiguration fallbackRetrieveConfigurations()
    {
        //returning the default configuration
        return new LimitConfiguration(999, 9);
    }
}
