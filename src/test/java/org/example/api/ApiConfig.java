// src/test/java/org/example/api/ApiConfig.java
package org.example.api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;

public class ApiConfig {

    protected static RequestSpecification requestSpec;

    @BeforeAll
    static void initSpec() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://jsonplaceholder.typicode.com")
                .setContentType("application/json")
                .build();
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}