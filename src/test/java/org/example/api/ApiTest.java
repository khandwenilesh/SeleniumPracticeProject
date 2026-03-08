package org.example.api;


import io.restassured.response.Response;
import org.example.api.models.Post;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApiTest extends ApiConfig {

    Post post = new Post();


    @Test
    @DisplayName("Sample POJO test")
    void PojoTest(){
        post.userId = 1;
        post.title  = "REST Assured Sample Test";
        post.body   = "Created via POJO";

        given()
                .spec(requestSpec)
                .body(post)
                .when()
                .post("/posts")
                .then()
                .statusCode(201);
    }

    // ---------------------------------------------------------------
    // GET  /posts/1  – validate status, headers, and body fields
    // ---------------------------------------------------------------
    @Test
    @DisplayName("GET /posts/1 - should return post with id 1")
    void testGetPost() {


        given()
                .spec(requestSpec)
                .when()
                .get("/posts/1")
                .then()
                .statusCode(200)
                .body("id",     equalTo(1))
                .body("userId", notNullValue())
                .body("title",  not(emptyOrNullString()))
                .body("body",   not(emptyOrNullString()));
    }

    // ---------------------------------------------------------------
    // GET  /posts  – validate the list size and structure
    // ---------------------------------------------------------------
    @Test
    @DisplayName("GET /posts - should return 100 posts")
    void testGetAllPosts() {
        given()
                .spec(requestSpec)
                .when()
                .get("/posts")
                .then()
                .log().status()
                .statusCode(200)
                .body("size()", equalTo(100));
    }

    // ---------------------------------------------------------------
    // POST /posts  – validate that a new resource is "created"
    // ---------------------------------------------------------------
    @Test
    @DisplayName("POST /posts - should create a new post and return 201")
    void testCreatePost() {
//        String requestBody = """
//                {
//                  "title":  "REST Assured Sample Test",
//                  "body":   "This is a sample post created by REST Assured",
//                  "userId": 1
//                }
//                """;

        post.userId = 1;
        post.title  = "REST Assured Sample Test";
        post.body   = "Created via POJO";

        Response response =
                given()
                        .spec(requestSpec)
                        .log().all()
                        .body(post)
                        .when()
                        .post("/posts")
                        .then()
                        .log().body()
                        .statusCode(201)
                        .extract().response();

        // Additional assertions via JUnit
        int id = response.jsonPath().getInt("id");
        assertTrue(id > 0, "Created post should have a positive id, but was: " + id);

        String title = response.jsonPath().getString("title");
        assertEquals("REST Assured Sample Test", title);
    }

    // ---------------------------------------------------------------
    @Test
    @DisplayName("GET /posts?userId=1 - should return only posts for userId 1")
    void testGetPostsByUserId() {
        given()
                .spec(requestSpec)
                .queryParam("userId", 1)
                .when()
                .get("/posts")
                .then()
                .log().status()
                .statusCode(200)
                .body("size()",        greaterThan(0))
                .body("userId",        everyItem(equalTo(1)))
                .body("title",         everyItem(not(emptyOrNullString())));
    }

    // ---------------------------------------------------------------
    // GET /posts/{id} – validate multiple post IDs via parameterized test
    // ---------------------------------------------------------------
    @ParameterizedTest(name = "GET /posts/{0} - should return status 200")
    @ValueSource(ints = {1, 5, 10, 50, 100})
    @DisplayName("GET /posts/{id} - parameterized status check")
    void testGetPostByIdParameterized(int postId) {
        given()
                .spec(requestSpec)
                .when()
                .get("/posts/" + postId)
                .then()
                .statusCode(200)
                .body("id", equalTo(postId));
    }


}
