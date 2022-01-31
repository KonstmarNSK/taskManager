package com.kostya.forms;

import com.kostya.entities.User;

import javax.validation.constraints.NotBlank;

public class RegisterForm {

    @NotBlank(message = "Name must be specified!")
    private String username;

    @NotBlank(message = "Email must be specified!")
    private String email;

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public User intoUser(){
        User result = new User();
        result.setName(username);
        result.setEmail(email);

        return result;
    }
}
