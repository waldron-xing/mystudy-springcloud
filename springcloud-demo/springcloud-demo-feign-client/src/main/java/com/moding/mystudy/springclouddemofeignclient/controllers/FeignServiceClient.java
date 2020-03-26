package com.moding.mystudy.springclouddemofeignclient.controllers;

import com.moding.mystudy.common.beans.Instance;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@FeignClient("feign-service")
@RestController
@RequestMapping("/feign-client")
public interface FeignServiceClient {
    @RequestMapping(value= "/instance/{serviceId}",method = RequestMethod.GET)
    public Instance getInstanceByServiceId(@PathVariable("serviceId") String serviceId);
}
