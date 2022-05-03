package com.assignment.HelloWorld.repository;

import com.assignment.HelloWorld.model.HelloWorldModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface HelloWorldRepository extends JpaRepository<HelloWorldModel, Long>, CrudRepository<HelloWorldModel, Long> {
    @Query(value = "select * from tbl_hello_world where lang like ?1", nativeQuery = true)
    HelloWorldModel GetByLang(String lang);
}
