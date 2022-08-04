package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
    private String name;
}
