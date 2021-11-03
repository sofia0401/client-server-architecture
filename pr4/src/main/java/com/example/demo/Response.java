package com.example.demo;

public class Response {

    private String responseContent;

    public Response() {
    }

    public Response(String responseContent) {
        this.responseContent = responseContent;
    }

    public String getResponseContent() {
        return responseContent;
    }

    public void setResponseContent(String responseContent) {
        this.responseContent = responseContent;
    }
}