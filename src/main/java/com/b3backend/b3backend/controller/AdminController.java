package com.b3backend.b3backend.controller;

import com.b3backend.b3backend.model.Admin;
import com.b3backend.b3backend.service.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/add")
    public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) {
        Admin newAdmin = adminService.addAdmin(admin);
        return new ResponseEntity<>(newAdmin, HttpStatus.CREATED);
    }

    @GetMapping("/search/{userName}")
    public ResponseEntity<Admin> findByUserName (@PathVariable("userName") String userName) {
        Admin admin = adminService.findByUserName(userName);

        return new ResponseEntity<>(admin, HttpStatus.OK);
    }
}

