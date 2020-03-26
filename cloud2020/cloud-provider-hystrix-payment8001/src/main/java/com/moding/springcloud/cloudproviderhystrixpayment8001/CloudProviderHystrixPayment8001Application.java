package com.moding.springcloud.cloudproviderhystrixpayment8001;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCircuitBreaker
public class CloudProviderHystrixPayment8001Application {
    public static void main(String[] args) {
        SpringApplication.run(CloudProviderHystrixPayment8001Application.class,args);
    }

    /**
     * 此配置是为了服务监控而配置，与 服务容错本身无关，springcloud升级后的坑
     * ServletRegistrationBean因为Springboot的默认路径不是“/hystrix.stream”,
     * 只要在自己的项目里配置上 下面的servlet就可以了
     * @return
     */
    @Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet streamServlet =  new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
