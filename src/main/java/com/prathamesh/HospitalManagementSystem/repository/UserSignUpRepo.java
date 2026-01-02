package com.prathamesh.HospitalManagementSystem.repository;

import com.prathamesh.HospitalManagementSystem.entity.UserSignUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSignUpRepo extends JpaRepository<UserSignUp,Long> {

    UserSignUp findByUsername(String username);
}
