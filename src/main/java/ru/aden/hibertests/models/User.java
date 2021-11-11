package ru.aden.hibertests.models;

public class User {
    private int id;
    private String name;
    private int age;
    private String email;

    //Default constructor
    public User() {
    }

    //Plain constructor
    public User(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    //Setters and Getters
     public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //toString method

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
