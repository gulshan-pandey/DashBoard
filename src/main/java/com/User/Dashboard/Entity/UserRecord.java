package com.User.Dashboard.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor@NoArgsConstructor
@Entity
public class UserRecord {

    @Id
    private Long id;
    private String name;
    private String email;
    private String password;
}
