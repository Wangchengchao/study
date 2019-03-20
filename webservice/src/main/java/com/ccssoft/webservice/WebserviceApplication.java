package com.ccssoft.webservice;

import com.ccssoft.webservice.config.BusinessConfig;
import com.ccssoft.webservice.entity.bss2bosspersonal.DeviceBind;
import com.ccssoft.webservice.entity.bss2bosspersonal.DeviceBindRequest;
import com.ccssoft.webservice.entity.bss2bosspersonal.ObjectFactory;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
@Slf4j
@RefreshScope
@EnableConfigurationProperties({BusinessConfig.class})
public class WebserviceApplication {
  
  @Value("${book.name}")
  private String name;
  
  @Value("${author.name}")
  private String custom;
  
  @Value("${book.price}")
  private String price;

  public static void main(String[] args) {
    SpringApplication.run(WebserviceApplication.class, args);
  }

  @GetMapping("/invoke")
  public String invoke() {
    // DeviceBindReq deviceBindReq = new DeviceBindReq();
    // deviceBindReq.setDetailParam("param");
    // deviceBindReq.setForcedFlag(1);
    // deviceBindReq.setMAC("fff-11");
    // deviceBindReq.setUserID("ID");
    // send.callDeviceBind(deviceBindReq, "aaaaaaaaaa");
    return "OK";
  }

  @GetMapping("/axis")
  public String axis() {
    DeviceBindRequest deviceBindReq = new ObjectFactory().createDeviceBindRequest();
    deviceBindReq.setDetailParam("param");
    deviceBindReq.setForcedFlag(10);
    deviceBindReq.setMac("00-FF-8A-99-22-7E");
    deviceBindReq.setUserID("ID");
    DeviceBind deviceBind = new DeviceBind();
    deviceBind.setDeviceBindReq(deviceBindReq);
    deviceBind.setSequenceID(UUID.randomUUID().toString());
    return "";
  }
  
  @GetMapping("/name")
  public String getName() {
    return this.name + "-" + this.custom + "-" + this.price;
  }
}
