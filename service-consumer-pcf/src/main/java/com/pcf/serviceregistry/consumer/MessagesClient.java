package com.pcf.serviceregistry.consumer;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("greeter-messages")
interface MessagesClient {
  @RequestMapping(value = "/greeting", method = RequestMethod.GET)
  Greeting greeting(@RequestParam("name") String name, @RequestParam("salutation") String salutation);
}