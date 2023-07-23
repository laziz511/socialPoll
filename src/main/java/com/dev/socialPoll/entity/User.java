package com.dev.socialPoll.entity;

import java.io.Serializable;
import java.time.LocalDate;

public class User implements Identifiable, Serializable {
    private long id;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private Gender gender;
    private String email;
    private String password;
    private UserRole role;

    public User() {}

    public User(long id, String firstName, String lastName, LocalDate birthday, Gender gender, String email, String password, UserRole role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User(String firstName, String lastName, LocalDate birthday, Gender gender, String email, String password, UserRole role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User(String firstName, String lastName, String birthday, String gender, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = LocalDate.parse(birthday);
        this.gender = Gender.valueOf(gender);
        this.email = email;
        this.password = password;
    }

    // Getters and setters

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    // equals, hashCode, and toString methods
}