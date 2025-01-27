package com.User.Dashboard.Repo;


import com.User.Dashboard.Entity.UserRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserRecord, Long> {

}
