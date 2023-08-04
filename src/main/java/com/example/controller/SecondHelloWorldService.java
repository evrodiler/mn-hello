package com.example.controller;

import io.micronaut.context.annotation.Primary;
import jakarta.inject.Singleton;


@Singleton
public class SecondHelloWorldService implements MyServiceInt{
    @Override
    public String helloFromService()
    {
        return "Hello from Second Service";
    }
}
