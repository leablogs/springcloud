package com.leablogs.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Value(value = "${eureka.client.service-url.defaultZone}")
    private String url;
    @RequestMapping(method = RequestMethod.GET,value = "/getUrl")
    public String getUrl() {
        return url;
    }
}
