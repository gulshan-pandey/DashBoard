package com.User.Dashboard.service;

import com.User.Dashboard.DTO.LoginRequest;
import com.User.Dashboard.DTO.RegisterRequest;
import com.User.Dashboard.Entity.UserCredential;
import com.User.Dashboard.Repo.UserCredentialsRepo;
import com.User.Dashboard.Repo.UserDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserCredentialService {

    @Autowired
    UserCredentialsRepo userCredentialsRepo;


//    public boolean findByEmail(LoginRequest loginRequest) {
//        return userCredentialsRepo.findByEmail(loginRequest.getUserId())
//                .map(credential -> credential.getPassword().equals(loginRequest.getPassword()))
//                .orElse(false);
//    }

    public boolean findByEmail(LoginRequest loginRequest) {
        Optional<UserCredential> optionalCredential = userCredentialsRepo.findByEmail(loginRequest.getUserId());
        if (optionalCredential.isPresent()) {
            UserCredential credential = optionalCredential.get();
            return credential.getPassword().equals(loginRequest.getPassword());
        } else {
            return false;
        }
    }



    public String registerCredentials(RegisterRequest registerRequest) {
        if (userCredentialsRepo.findByEmail(registerRequest.getEmail()).isPresent()) {
            return "User already registered";
        }

        UserCredential userCredentials = new UserCredential(
                registerRequest.getEmail(),
                registerRequest.getPassword()
        );

        UserCredential saved = userCredentialsRepo.save(userCredentials);
        return "User " + saved.getEmail() + " registered successfully";
    }
}