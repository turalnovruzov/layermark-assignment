package com.turalnovruzov.layermarkassignment.author;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class AuthorRequest {

    @NotNull
    private String name;

    @Positive
    @NotNull
    private Integer age;

    public AuthorRequest(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
