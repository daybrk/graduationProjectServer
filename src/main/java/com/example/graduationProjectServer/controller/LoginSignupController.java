package com.example.graduationProjectServer.controller;

import com.example.graduationProjectServer.enity.Roles;
import com.example.graduationProjectServer.enity.UserAndRole;
import com.example.graduationProjectServer.enity.UserAndRoleId;
import com.example.graduationProjectServer.enity.UserStructure;
import com.example.graduationProjectServer.repository.UserAndRoleRepo;
import com.example.graduationProjectServer.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoginSignupController {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserAndRoleRepo userAndRoleRepo;

    @PostMapping("/registration")
    public ResponseEntity createNewUser(@RequestBody UserStructure user) {
        try {
            UserStructure userFromDb = userRepo.findByEmail(user.getEmail());
            if (userFromDb != null) {
                return ResponseEntity.badRequest().body("Пользователь с такими email уже сущетсвует");
            } else {
                userRepo.save(user);
                userAndRoleRepo.save(new UserAndRole(new UserAndRoleId(user, Roles.USER)));
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
    public ResponseEntity<String> authorizationUser(@PathVariable(value = "email") String email,
                                                    @PathVariable(value = "password") String password) {
        try {
            if (email.equals("")) {
                return ResponseEntity.badRequest().body("Введите email");
            } else if (password.equals("")) {
                return new ResponseEntity<>("Введите пароль", HttpStatus.NO_CONTENT);
            } else {
                // gettinguser изначально пустой, потом мы кладем внего все данные пользователя
                UserStructure gettingUser = userRepo.findByEmail(email);
                System.out.println(email + " " + password + " " + gettingUser);
                if (gettingUser != null) {
                    // проверка на правильность введенного пароля
                    if (password.equals(gettingUser.getPassword())) {
                        System.out.println("Авторизация что-то");
                        return ResponseEntity.ok("Авторизация прошла успешно");
                    } else {
                        return ResponseEntity.badRequest().body("Введённый пароль неверный");
                    }
                    // если gettinguser = null то выводит это
                } else {
                    return ResponseEntity.badRequest().body("Пользователя с таким email не существует");
                }
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/user/{email}")
    public UserStructure authorizationUser(@PathVariable String email) {
        try {
            return userRepo.findByEmail(email);
        } catch (Exception e) {
            return null;
        }
    }
}
