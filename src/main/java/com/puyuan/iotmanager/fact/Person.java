package com.puyuan.iotmanager.fact;

import lombok.Data;

@Data
public class Person {

    private String name;
    private Integer age;
    private String className;


    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
