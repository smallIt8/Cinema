package org.example.model;

import java.util.UUID;

public class Person {
    private UUID id;
    private String userName;
    private String password;
    private String email;
    private Role role;

    public Person() {
    }

    public Person(String userName, String password, Role role) {
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    public Person(UUID id, String userName, String password, String email) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public Person(UUID id, String userName, String password, String email, Role role) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
