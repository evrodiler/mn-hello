package com.example;

import com.fasterxml.jackson.databind.JsonNode;
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
    @Test
    void helloFromConfigEndpointReturnsMessageFromConfigFile()
    {
        var response =  client.toBlocking().exchange("/hello/config", String.class);
        assertEquals(HttpStatus.OK, response.getStatus());
        assertEquals("Hello from application.yml", response.getBody().get());
    }
    @Test
    void helloFromTranslationEndpointReturnsMessageFromConfigFile()
    {
        var response = client.toBlocking().exchange("/hello/translation", JsonNode.class);
        assertEquals(HttpStatus.OK, response.getStatus());
        assertEquals("{\"de\":\"Hallo Welt\",\"en\":\"Hello World\"}", response.getBody().get().toString());
    }

}
