package com.User.Dashboard.Repo;

import com.User.Dashboard.Entity.UsersDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDetailsRepo extends JpaRepository<UsersDetails, String > {

    Optional<UsersDetails> findByUsername(String username);

    Optional<UsersDetails> findByUserCredential_Email(String email);



}
