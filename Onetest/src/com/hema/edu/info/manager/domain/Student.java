package com.hema.edu.info.manager.domain;

public class Student {
    private  String id;



    private  String name;
    private  String age;
    private  String day;

    public Student() {
    }
    public Student(String id, String name, String age, String day) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.day = day;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
