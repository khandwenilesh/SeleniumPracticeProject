package org.example.api.tests;

import io.restassured.response.Response;
import org.example.api.models.UserRequest;
import org.example.api.services.UserService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class PostApiTest  {

    UserService postService = new UserService();

    @Test
    public void verifyGetPost(){

        Response response = postService.getPost(1);

        assertEquals(response.getStatusCode(),200);

        String title =
                response.jsonPath().getString("title");

        System.out.println("Post Title : " + title);
    }

    @Test
    public void verifyGetAllPosts(){

        Response response = postService.getAllPosts();

        assertEquals(response.getStatusCode(),200);

        int totalPosts =
                response.jsonPath().getList("$").size();

        System.out.println("Total Posts : " + totalPosts);
    }

    @Test
    public void verifyCreatePost(){

        UserRequest request =
                new UserRequest(
                        "Automation Testing",
                        "Learning Rest Assured",
                        "1");

        Response response =
                postService.createPost(request);

      assertEquals(response.getStatusCode(),201);

        String title =
                response.jsonPath().getString("title");

        assertEquals(title,"Automation Testing");
    }

    @Test
    public void verifyUpdatePost(){

        UserRequest request =
                new UserRequest(
                        "Updated Title",
                        "Updated Body",
                        "1");

        Response response =
                postService.updatePost(1,request);
        assertEquals(response.getStatusCode(),200);

        String title =
                response.jsonPath().getString("title");

     assertEquals(title,"Updated Title");
    }

    @Test
    public void verifyDeletePost(){

        Response response =
                postService.deletePost(1);

        assertEquals(response.getStatusCode(),200);
    }
}