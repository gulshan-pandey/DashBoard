package com.User.Dashboard.DTO;

public class RegisterUserDetails {


    private String username;
    private String password;
    private String phone;
    private int age;
    private String address;


    public RegisterUserDetails() {}

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}