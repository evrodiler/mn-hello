package com.example.controller;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/hello")
public class HelloWorldController {

    //field base injection
//    @Inject
//    private HelloWorldService service;

    //constructor based injection no need to use an inject command
    //private final HelloWorldService service;

    private final MyServiceInt service;

    public HelloWorldController(MyServiceInt service) {
        this.service = service;
    }

    @Get(produces = MediaType.TEXT_PLAIN)
    public String helloWorld()
    {
        return service.helloFromService();
        //return "Hello World";
    }

}
