package com.example.jwt.demo.payload.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response<T> {

    @JsonProperty("status_code")
    private Integer statusCode;

    @JsonProperty("message")
    private String message;

    @JsonProperty("data")
    private T data;

    public Response() {
    }

    public Response(Integer statusCode, String message, T data) {
        this.setStatusCode(statusCode);
        this.setMessage(message);
        this.setData(data);
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
