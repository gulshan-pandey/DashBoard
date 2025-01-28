package com.User.Dashboard.DTO;

public class UserOrgDetailsDTO {

    private String managerName;
    private String organization;
    private String companyAddress;



    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    // Constructor
    public UserOrgDetailsDTO(String managerName, String organization, String companyAddress) {
        this.managerName = managerName;
        this.organization = organization;
        this.companyAddress = companyAddress;
    }

    public UserOrgDetailsDTO() {}
}
