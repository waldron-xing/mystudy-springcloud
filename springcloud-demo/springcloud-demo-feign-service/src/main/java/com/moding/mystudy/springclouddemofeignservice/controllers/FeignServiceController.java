package com.moding.mystudy.springclouddemofeignservice.controllers;

import com.moding.mystudy.common.beans.Instance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class FeignServiceController {
    private static final Logger logger = LoggerFactory.getLogger(FeignServiceController.class);

    private static String DEFAULT_SERVICE_ID = "application";
    private static String DEFAULT_HOST = "localhost";
    private static int DEFAULT_PORT = 8080;

    @RequestMapping(value = "/instance/{serviceId}",method = RequestMethod.GET)
    public Instance getInstanceByServiceId(@PathVariable("serviceId") String serviceId){
        logger.info("Get Instance by serviceId {}", serviceId);
        return new Instance(serviceId, DEFAULT_HOST, DEFAULT_PORT);
    }
}
