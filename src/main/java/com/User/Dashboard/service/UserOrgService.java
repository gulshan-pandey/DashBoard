package com.User.Dashboard.service;

import com.User.Dashboard.DTO.UserOrgDetailsDTO;
import com.User.Dashboard.Entity.UserOrgDetails;
import com.User.Dashboard.Entity.UsersDetails;
import com.User.Dashboard.Repo.UserDetailsRepo;
import com.User.Dashboard.Repo.UserOrgRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class UserOrgService {
    @Autowired
    private UserOrgRepo userOrgRepo;

    @Autowired
    private UserDetailsRepo userDetailsRepo;


    public String registerUserOrg(String username, UserOrgDetailsDTO dto) {
        UsersDetails usersDetails = userDetailsRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Please complete personal details registration first"));

        UserOrgDetails userOrgDetails = new UserOrgDetails(
                dto.getManagerName(),
                dto.getOrganization(),
                dto.getCompanyAddress()
        );
        userOrgDetails.setUsersDetails(usersDetails);

        UserOrgDetails saved = userOrgRepo.save(userOrgDetails);
        return "Organization details saved for user " + username;
    }

    public UserOrgDetails findByUsername(String username) {
        return userOrgRepo.findByUsersDetails_Username(username);
    }

    public List<UserOrgDetails> findAllUserOrg() {
        return userOrgRepo.findAll();
    }
}