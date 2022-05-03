package com.assignment.HelloWorld.repository;

import com.assignment.HelloWorld.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    @Query(value = "select * from tbl_users where username like ?1 and password like ?2", nativeQuery = true)
    UserModel GetUser(String username,String password);
}
