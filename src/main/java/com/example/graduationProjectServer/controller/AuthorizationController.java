package com.example.graduationProjectServer.controller;

import com.example.graduationProjectServer.enity.UserEmployee;
import com.example.graduationProjectServer.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.NoSuchElementException;

@Controller
public class AuthorizationController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/login")
    public ResponseEntity authorizationUser(@RequestBody UserEmployee user) {
        try {
            if (user.getEmail() == null) {
                return ResponseEntity.badRequest().body("Введите email");
            } else if (user.getPassword() == null) {
                return ResponseEntity.badRequest().body("Введите пароль");
            } else {
                UserEmployee gettingUser =
                        userRepo.findById(user.getEmail()).orElseThrow(() -> new NoSuchElementException("Ошибка - Неверный email"));
                if (user.getPassword().equals(gettingUser.getPassword())) {
                    return ResponseEntity.ok("Авторизация прошла успешно");
                } else {
                    return ResponseEntity.badRequest().body("Введённый пароль неверный");
                }

            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
