package com.example.graduationProjectServer.controller;

import com.example.graduationProjectServer.enity.UserEmployee;
import com.example.graduationProjectServer.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/registration")
    public ResponseEntity createNewUser(@RequestBody UserEmployee user) {
        try {
            if (user.getEmail() == null) {
                return ResponseEntity.badRequest().body("Введите e-mail");
            } else if (user.getName() == null) {
                return ResponseEntity.badRequest().body("Введите Имя");
            } else if (user.getSecondName() == null) {
                return ResponseEntity.badRequest().body("Введите Фамилию");
            } else if (user.getPassword() == null) {
                return ResponseEntity.badRequest().body("Введите Пароль");
            } else {
                //TODO: Добавление пользователя в базу
                userRepo.save(user);
                return ResponseEntity.ok("Регистрация завершена");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

}
