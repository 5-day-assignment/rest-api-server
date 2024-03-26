package com.assignment5d.restapiserver.repository;

import com.assignment5d.restapiserver.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {

    // Note: JpaRepository provides basic CRUD operations and query methods.
}
