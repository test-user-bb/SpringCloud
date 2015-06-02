
package sample;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@RestController
@RefreshScope 

public class CloudClinet {

	@Value("${foo:World!}")
    String fooValue;

    @RequestMapping("/hello")
    String hello() {
        return "Hello " + fooValue + "!";
    }
    
	public static void main(String[] args) {
		SpringApplication.run(CloudClinet.class, args);
	}

}
