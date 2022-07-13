package com.leablogs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
public class TraceTwo {
    private final Logger logger = LoggerFactory.getLogger(TraceTwo.class);
    @RequestMapping(value = "/trace-2",method = RequestMethod.GET)
    public String trace(HttpServletRequest request){
        logger.info("=====<call trace-2>,TraceId={}, SpanId={}=====",request.getHeader("X-B3-TraceId"),
                request.getHeader("X-B3-SpanId"));
        return "Trace";
    }
}


















