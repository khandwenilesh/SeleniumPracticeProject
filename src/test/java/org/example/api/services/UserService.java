package org.example.api.services;

import io.restassured.response.Response;
import org.example.api.ApiClient;
import org.example.api.models.UserRequest;

public class UserService {

    public Response getPost(int id){

        return ApiClient.get("/posts/" + id);
    }

    public Response getAllPosts(){

        return ApiClient.get("/posts");
    }

    public Response createPost(UserRequest request){

        return ApiClient.post("/posts",request);
    }

    public Response updatePost(int id,UserRequest request){

        return ApiClient.put("/posts/"+id,request);
    }

    public Response deletePost(int id){

        return ApiClient.delete("/posts/"+id);
    }
}