package com.b3backend.b3backend.service;

import com.b3backend.b3backend.exception.UserNotFoundException;
import com.b3backend.b3backend.model.Admin;
import com.b3backend.b3backend.repo.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AdminService {
    private final AdminRepo adminRepo;

    @Autowired
    public AdminService(AdminRepo adminRepo) {
        this.adminRepo = adminRepo;
    }

    public Admin addAdmin(Admin admin) {
        return adminRepo.save(admin);
    }


    public Admin findByUserName(String userName) {
        return adminRepo.findByUserName(userName).orElseThrow(() -> new UserNotFoundException("User by username" + userName + "was not found"));
    }

}
