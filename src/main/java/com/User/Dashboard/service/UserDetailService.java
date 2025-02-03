package com.User.Dashboard.service;

import com.User.Dashboard.DTO.RegisterUserDetails;
import com.User.Dashboard.Entity.UserCredential;
import com.User.Dashboard.Entity.UsersDetails;
import com.User.Dashboard.Repo.UserCredentialsRepo;
import com.User.Dashboard.Repo.UserDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;




@Service
@Transactional
public class UserDetailService {

    @Autowired
    private UserDetailsRepo userDetailsRepo;

    @Autowired
    private UserCredentialsRepo userCredentialsRepo;

    public Optional<UsersDetails> findByUsername(String username) {
        return userDetailsRepo.findByUserCredential_Email(username);
    }

    public String registerUserPersonalInfo(String email,RegisterUserDetails registerUserDetails) {



        if (userDetailsRepo.findByUsername(registerUserDetails.getUsername()).isPresent()) {
            return "Username already exists";
        }

        UserCredential userCredential = userCredentialsRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User credentials not found"));

        UsersDetails usersDetails = new UsersDetails(
                registerUserDetails.getUsername(),
                registerUserDetails.getPhone(),
                registerUserDetails.getAge(),
                registerUserDetails.getAddress()
        );
        usersDetails.setUserCredential(userCredential);

        UsersDetails saved = userDetailsRepo.save(usersDetails);
        return "User " + saved.getUsername() + " details registered successfully";
    }

    public List<UsersDetails> findAll() {
        return userDetailsRepo.findAll();
    }
}
