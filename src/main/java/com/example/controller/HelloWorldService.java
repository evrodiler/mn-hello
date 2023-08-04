package com.example.controller;

import io.micronaut.context.annotation.Primary;
import jakarta.inject.Singleton;

@Primary
@Singleton
public class HelloWorldService implements MyServiceInt{
    @Override
    public String helloFromService()
    {
        return "Hello from Service";
    }

}

/*
@Singleton
public class HelloWorldService {
    public String helloFromService ()
    {
        return "Hello from Service";
    }
}
*/
