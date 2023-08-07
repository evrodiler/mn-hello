package com.example.controller;

import io.micronaut.context.annotation.Property;
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
    private final String helloFromConfig;
    private final HelloWorldTranslationConfig translationConfig; //configuration injection

    public HelloWorldController(MyServiceInt service,
                                @Property(name= "hello.world.message") String helloFromConfig,
                                HelloWorldTranslationConfig translationConfig)
    {
        this.service = service;
        this.helloFromConfig = helloFromConfig;
        this.translationConfig = translationConfig;
    }

    @Get(produces = MediaType.TEXT_PLAIN)
    public String helloWorld()
    {
        LOG.debug("called the helloWorld from controller");
        return service.helloFromService();
        //return "Hello World";
    }

    @Get(uri = "/config", produces = MediaType.TEXT_PLAIN)
    public String helloFromConfig()
    {
        LOG.debug("return from config message hello:{}", helloFromConfig);
        return helloFromConfig;
    }

    @Get(uri = "/translation", produces = MediaType.APPLICATION_JSON)
    public HelloWorldTranslationConfig helloTranslation()
    {
        return translationConfig;
    }

}
