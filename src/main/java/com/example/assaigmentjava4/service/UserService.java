package com.example.assaigmentjava4.service;

import com.example.assaigmentjava4.entity.Users;

import java.util.List;

public interface UserService {
    List<Users> getAllUsers();
    Users getUserById(int id);
    int addUser(Users user);
    int updateUser(Users user);
    int deleteUser(int id);
    Users checkLogin(String email);
}
