package com.User.Dashboard.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
public class UserCredential {

    @Id
    private String email;

    @Column(length = 100)
    private String password;

    @OneToOne(mappedBy = "userCredential", cascade = CascadeType.ALL)
    @JsonManagedReference("usercred")
    public UsersDetails usersDetails;


    public UserCredential() {
    }



    public UserCredential(String email, String username) {
        this.email = email;
        this.password = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UsersDetails getUsersDetails() {
        return usersDetails;
    }

    public void setUsersDetails(UsersDetails usersDetails) {
        this.usersDetails = usersDetails;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
