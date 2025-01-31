package com.User.Dashboard.Repo;


import com.User.Dashboard.Entity.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


import java.util.Optional;

@Repository
public interface UserCredentialsRepo extends JpaRepository<UserCredential,String> {

    Optional<UserCredential> findByEmail(String email);

}
