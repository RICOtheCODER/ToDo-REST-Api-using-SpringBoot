package com.Wiley.mytodoApp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {

   private int uid;

    private String firstname;
    private String lastname;
    private String email;
    private String contact;

    public User(String firstname, String lastname, String email, String contact) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.contact = contact;
    }
}
