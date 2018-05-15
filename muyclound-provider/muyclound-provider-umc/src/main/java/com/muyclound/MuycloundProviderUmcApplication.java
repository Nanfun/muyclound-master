package com.muyclound;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableHystrix
@EnableFeignClients
@EnableEurekaClient
@EnableTransactionManagement
public class MuycloundProviderUmcApplication {

  public static void main(String[] args) {
    SpringApplication.run(MuycloundProviderUmcApplication.class, args);
  }
}
