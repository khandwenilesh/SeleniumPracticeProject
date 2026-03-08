package org.example.api.models;
import com.fasterxml.jackson.annotation.JsonProperty;
public class UserRequest {

    @JsonProperty("userID")  private String userID;
    @JsonProperty("title")   private String title;
    @JsonProperty("body")    private String body;

    public UserRequest(String title, String body, String userID){

        this.userID = userID;
        this.title  = title;
        this.body   = body;
    }

}