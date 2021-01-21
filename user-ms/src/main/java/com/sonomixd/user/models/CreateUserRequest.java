package com.sonomixd.user.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateUserRequest {

    @NotNull(message = "First name must not be null")
    @Size(min = 2, message = "First name must be more then 2 characters")
    private String firstName;

    @NotNull(message = "Last name must not be null")
    @Size(min = 2, message = "Last name must be more then 2 characters")
    private String lastName;

    @NotNull(message = "Password must not be null")
    @Size(min = 6, max = 16, message = "Password must be between 6 and 16 characters")
    private String password;

    @NotNull
    @Email
    private String email;

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
}
