package com.example.controller;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@Controller("/hello")
public class HelloWorldController {

    //field base injection
//    @Inject
//    private HelloWorldService service;

    //constructor based injection no need to use an inject command
    //private final HelloWorldService service;

    private final MyServiceInt service;
    private static final Logger LOG = LoggerFactory.getLogger(HelloWorldController.class);

    public HelloWorldController(MyServiceInt service) {
        this.service = service;
    }

    @Get(produces = MediaType.TEXT_PLAIN)
    public String helloWorld()
    {
        LOG.debug("called the helloWorld from controller");
        return service.helloFromService();
        //return "Hello World";
    }

}
