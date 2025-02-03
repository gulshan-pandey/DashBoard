package com.User.Dashboard.controller;

import com.User.Dashboard.DTO.LoginRequest;
import com.User.Dashboard.DTO.RegisterRequest;
import com.User.Dashboard.DTO.RegisterUserDetails;
import com.User.Dashboard.DTO.UserOrgDetailsDTO;
import com.User.Dashboard.Entity.UserOrgDetails;
import com.User.Dashboard.Entity.UsersDetails;
import com.User.Dashboard.service.UserCredentialService;
import com.User.Dashboard.service.UserDetailService;
import com.User.Dashboard.service.UserOrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
//@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {
    @Autowired
    private UserCredentialService userCredentialService;

    @Autowired
    private UserDetailService userDetailService;

    @Autowired
    private UserOrgService userOrgService;


    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Service is running");
    }

    // Authentication endpoints
    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody LoginRequest loginRequest) {
        boolean isValid = userCredentialService.findByEmail(loginRequest);
        return ResponseEntity.ok(isValid);
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody RegisterRequest registerRequest) {
        String result = userCredentialService.registerCredentials(registerRequest);
        return ResponseEntity.ok(result);
    }

    // User Details endpoints
    @PostMapping("/user-details/{email}")
    public ResponseEntity<String> registerUserDetails(
            @PathVariable String email,
            @RequestBody RegisterUserDetails registerUserDetails) {
        try {
            String result = userDetailService.registerUserPersonalInfo(email, registerUserDetails);
            return ResponseEntity.ok(result);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/user-details/{username}")
    public ResponseEntity<?> getUserDetails(@PathVariable String username) {
        Optional<UsersDetails> userDetails = userDetailService.findByUsername(username);
        if (userDetails.isPresent()) {
            return ResponseEntity.ok(userDetails);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/findall-details")
    public List<UsersDetails> getUserDetails() {
        return userDetailService.findAll();
    }


    // Organization Details endpoints
    @PostMapping("/org-details/{username}")
    public ResponseEntity<String> registerOrgDetails(
            @PathVariable String username,
            @RequestBody UserOrgDetailsDTO userOrgDetailsDTO) {
        try {
            String result = userOrgService.registerUserOrg(username, userOrgDetailsDTO);
            return ResponseEntity.ok(result);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/org-details/{username}")
    public ResponseEntity<UserOrgDetails>getOrgDetails(@PathVariable String username) {
        UserOrgDetails orgDetails = userOrgService.findByUsername(username);
        return ResponseEntity.ok(orgDetails);
    }

    @GetMapping("/find-all-userOrg")
    public List<UserOrgDetails> findAllUserOrg () {

        return userOrgService.findAllUserOrg();

    }


}