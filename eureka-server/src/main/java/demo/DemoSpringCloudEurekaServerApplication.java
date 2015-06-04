package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * To see the list of registered services:
 * http://localhost:8761/eureka/apps/
 * 
 * @author 6810
 *
 */
@SpringBootApplication
@EnableEurekaServer
@RestController
public class DemoSpringCloudEurekaServerApplication {

	@RequestMapping("/hello")
	public String home() {
		return "Hello world from Eureka Server";
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringCloudEurekaServerApplication.class,
				args);
	}
}
