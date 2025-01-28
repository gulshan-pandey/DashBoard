package com.User.Dashboard.Entity;

import jakarta.persistence.*;



@Entity
public class UserOrgDetails {

    @Id
    private String username;

    @OneToOne
    @JoinColumn(name = "username")
    private UsersDetails usersDetails;

    @Column
    private String managerName;

    @Column
    private String organization;

    @Column
    private String companyAddress;

    // Constructors
    public UserOrgDetails() {}

    public UserOrgDetails(String managerName, String organization, String companyAddress) {
        this.managerName = managerName;
        this.organization = organization;
        this.companyAddress = companyAddress;
    }

    // Getters and setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public UsersDetails getUsersDetails() { return usersDetails; }
    public void setUsersDetails(UsersDetails usersDetails) {
        this.usersDetails = usersDetails;
        this.username = usersDetails.getUsername();
    }
    public String getManagerName() { return managerName; }
    public void setManagerName(String managerName) { this.managerName = managerName; }
    public String getOrganization() { return organization; }
    public void setOrganization(String organization) { this.organization = organization; }
    public String getCompanyAddress() { return companyAddress; }
    public void setCompanyAddress(String companyAddress) { this.companyAddress = companyAddress; }
}