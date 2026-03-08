package org.example.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.utils.ConfigReader;

public class ApiClient {

    static {
        RestAssured.baseURI = ConfigReader.get("base.api.url");
    }

    public static Response get(String endpoint){

        return RestAssured
                .given()
                .log().all()
                .when()
                .get(endpoint);
    }

    public static Response post(String endpoint,Object body){

        return RestAssured
                .given()
                .header("Content-Type","application/json")
                .body(body)
                .when()
                .post(endpoint);
    }

    public static Response delete(String endpoint){

        return RestAssured
                .given()
                .log().all()
                .when()
                .delete(endpoint);
    }

        public static Response put(String endpoint,Object body){

            return RestAssured
                    .given()
                    .header("Content-Type","application/json")
                    .body(body)
                    .when()
                    .put(endpoint);
        }
}