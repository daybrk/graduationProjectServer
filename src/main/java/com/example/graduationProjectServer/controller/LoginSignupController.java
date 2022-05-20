package com.example.graduationProjectServer.controller;

import com.example.graduationProjectServer.enity.*;
import com.example.graduationProjectServer.repository.UserRoleRepo;
import com.example.graduationProjectServer.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

@RestController
public class LoginSignupController {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserRoleRepo userRoleRepo;

    @PostMapping("/registration")
    public ResponseEntity createNewUser(@RequestBody UserStructure user) {
        try {
            UserStructure userFromDb = userRepo.findByEmail(user.getEmail());
            if (userFromDb != null) {
                return ResponseEntity.badRequest().body("Пользователь с такими email уже сущетсвует");
            } else {
                userRepo.save(user);
                userRoleRepo.save(new UserRole(user, Roles.USER));
                return ResponseEntity.ok("Регистрация прошла успешно");
            }
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.badRequest().body(e);
        }
    }
// endpoint login передаем емаил пароль
    @GetMapping("/login/{email}/{password}")
    // pathvariable позволяет передать значения из урл выше 
    public AuthResponse authorizationUser(@PathVariable(value = "email") String email,
                                          @PathVariable(value = "password") String password) {
        try {
            if (email.equals("")) {
                return new AuthResponse(null, "Пустое поле с email");
            } else if (password.equals("")) {
                return new AuthResponse(null, "Пустое поле с паролем");
            } else {
                // gettinguser изначально пустой, потом мы кладем внего все данные пользователя
                UserStructure gettingUser = userRepo.findByEmail(email);
                if (gettingUser != null) {
                    // проверка на правильность введенного пароля
                    if (password.equals(gettingUser.getPassword())) {

                        return new AuthResponse(userRoleRepo.findUserRoleByUserEmail(gettingUser).getRole().toString(), "");
                    } else {
                        return new AuthResponse(null, "Введён неверный пароль");
                    }
                    // если gettinguser = null то выводит это
                } else {
                    return new AuthResponse(null, "Пользователя с таким email не существует");
                }
            }
        } catch (Exception e) {
            return new AuthResponse(null, e.getMessage());
        }
    }


}
