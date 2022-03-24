package com.sqa.Insurance.repository;

import com.sqa.Insurance.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    @Query("select u from User u where u.username = ?1 and u.cccd = ?2")
    User findUser(String username, String cccd);

    User findById(long id);
}
