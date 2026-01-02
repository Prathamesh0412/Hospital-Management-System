package com.prathamesh.HospitalManagementSystem.controller;

import com.prathamesh.HospitalManagementSystem.entity.Role;
import com.prathamesh.HospitalManagementSystem.entity.UserSignUp;
import com.prathamesh.HospitalManagementSystem.repository.UserSignUpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserSignUpController {

    @Autowired
    private UserSignUpRepo userSignUpRepo;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @PostMapping("/signup")
    public String signUp(@RequestBody UserSignUp user){
        user.setPassword(encoder.encode(user.getPassword()));

        // Assign role internally
        if ("admin".equalsIgnoreCase(user.getUsername())) {
            user.setRole(Role.ADMIN);
        } else if (user.getUsername().toLowerCase().startsWith("doc")) {
            user.setRole(Role.DOCTOR);
        } else {
            user.setRole(Role.PATIENT);
        }
        userSignUpRepo.save(user);

        return "Sign up successfully!";
    }

}
