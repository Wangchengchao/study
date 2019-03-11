package com.ccssoft.webservice;

import com.ccssoft.webservice.entity.DeviceBind;
import com.ccssoft.webservice.entity.ObjectFactory;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@Slf4j
public class WebserviceApplication {
  
  @Autowired
  @Qualifier("send")
  Send sender;

  @Value("${user.info.name}")
  private String name;

  @Value("${user.info.age}")
  private String age;

  public static void main(String[] args) {
    SpringApplication.run(WebserviceApplication.class, args);
  }

  @GetMapping("/invoke")
  public String invoke() throws Exception {
    // DeviceBindReq deviceBindReq = new DeviceBindReq();
    // deviceBindReq.setDetailParam("param");
    // deviceBindReq.setForcedFlag(1);
    // deviceBindReq.setMAC("fff-11");
    // deviceBindReq.setUserID("ID");
    // send.callDeviceBind(deviceBindReq, "aaaaaaaaaa");
    return "OK";
  }

  @GetMapping("/name")
  public String getName() {
  
    return this.name;
  }
  
  @GetMapping("/age")
  public String getAge() {
    
    return this.age;
  }
  
  @GetMapping("/axis")
  public String axis() {
    com.ccssoft.webservice.entity.DeviceBindReq deviceBindReq =
        new ObjectFactory().createDeviceBindReq();
    deviceBindReq.setDetailParam("param");
    deviceBindReq.setForcedFlag(10);
    deviceBindReq.setMAC("00-FF-8A-99-22-7E");
    deviceBindReq.setUserID("ID");
    DeviceBind deviceBind = new ObjectFactory().createDeviceBind();
    deviceBind.setDeviceBindReq(deviceBindReq);
    deviceBind.setSequenceID(UUID.randomUUID().toString());
    return sender.axis(deviceBind);
  }
}
