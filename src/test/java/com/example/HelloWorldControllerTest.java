package com.example;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


@MicronautTest
public class HelloWorldControllerTest {
    @Inject
            @Client("/")
    HttpClient client;

    @Test
    void HelloWorldEndpointRespondsWithProperContent()
    {
        var response = client.toBlocking().retrieve("/hello"); // returns body
        assertEquals("Hello from Service", response);

    }
    @Test
    void HelloWorldEndpointRespondsWithStatusCodeAndProperContent()
    {
        var response = client.toBlocking().exchange("/hello", String.class); //returns status also
        assertEquals(HttpStatus.OK, response.getStatus());
        assertEquals("Hello from Service", response.getBody().get());
    }

}
