package com.blog_api_com.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserDto {

    private int id;

    @NotBlank
    @Size(min = 4, message = "User name should be min of 4 characters!")
    private String name;

    @NotBlank
    @Email(message = "Please enter valid Email address.")
    private String email;

    @NotBlank
    @Size(min = 8, max = 20, message = "Please Enter password between 8 to 20 characters")
    private String password;

    @NotBlank
    private String about;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotBlank @Size(min = 4, message = "User name should be min of 4 characters!") String getName() {
        return name;
    }

    public void setName(@NotBlank @Size(min = 4, message = "User name should be min of 4 characters!") String name) {
        this.name = name;
    }

    public @NotBlank @Email(message = "Please enter valid Email address.") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank @Email(message = "Please enter valid Email address.") String email) {
        this.email = email;
    }

    public @NotBlank @Size(min = 8, max = 20, message = "Please Enter password between 8 to 20 characters") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank @Size(min = 8, max = 20, message = "Please Enter password between 8 to 20 characters") String password) {
        this.password = password;
    }

    public @NotBlank String getAbout() {
        return about;
    }

    public void setAbout(@NotBlank String about) {
        this.about = about;
    }
}
