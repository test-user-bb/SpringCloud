package demo;

import java.net.URI;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestOperations;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableHystrixDashboard
public class DemoSpringCloudEurekaClientApplication {
	private Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	RestOperations rest;
	
	//@Autowired
	//private DiscoveryClient discoveryClient;
	
	/*public URI serviceUrl() {
	    List<ServiceInstance> list = client.getInstances("STORES");
	    if (list != null && list.size() > 0 ) {
	        return list.get(0).getUri();
	    }
	    return null;
	}
	*/
	
	@Autowired
	private DiscoveryClient discoveryClient;

	public String serviceUrl() {
	    InstanceInfo instance = discoveryClient.getNextServerFromEureka("DEMO-EUREKA-CLIENT", false);
	    return instance.getHomePageUrl();
	}
	
	@RequestMapping("/")
	public String home() throws Exception {
		
			logger.info("DemoSpringCloudEurekaClientApplication.home()");
		
		return serviceUrl();
	}
	
    public static void main(String[] args) {
        SpringApplication.run(DemoSpringCloudEurekaClientApplication.class, args);
    }

}
