package com.example.demo.Repository;

import com.example.demo.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    @Query("SELECT u from  Users u where u.name = :name")
    public Users getUsersByName(@Param("name") String name);
    Optional<Users> findByEmail(String email);
    Optional<Users> findByName(String name);
    Boolean existsByEmail(String email);
    Boolean existsByName(String name);
}
