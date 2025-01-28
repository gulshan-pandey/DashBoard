package com.User.Dashboard.Repo;

import com.User.Dashboard.Entity.UserOrgDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserOrgRepo extends JpaRepository<UserOrgDetails, String> {
//   Optional<UserOrgDetails> findByUsernameAllIgnoreCase(String username);


    UserOrgDetails findByUsersDetails_Username(String username);

    Optional<Object> findByUsername(String username);

}