package com.User.Dashboard.Entity;

import com.User.Dashboard.Entity.UserCredential;
import com.User.Dashboard.Entity.UserOrgDetails;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
public class UsersDetails {
    @Id
    private String username;

    @OneToOne
    @JoinColumn(name = "email", unique = true)
    private UserCredential userCredential;

    @Column(length = 10)
    private String phone;

    @Column
    private int age;

    @Column
    private String address;

    @OneToOne(mappedBy = "usersDetails", cascade = CascadeType.ALL)
    private UserOrgDetails userOrgDetails;

    // Constructors
    public UsersDetails() {}

    public UsersDetails(String username, String phone, int age, String address) {
        this.username = username;
        this.phone = phone;
        this.age = age;
        this.address = address;
    }

    // Getters and setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public UserCredential getUserCredential() { return userCredential; }
    public void setUserCredential(UserCredential userCredential) { this.userCredential = userCredential; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public UserOrgDetails getUserOrgDetails() { return userOrgDetails; }
    public void setUserOrgDetails(UserOrgDetails userOrgDetailsList) { this.userOrgDetails = userOrgDetails; }
}