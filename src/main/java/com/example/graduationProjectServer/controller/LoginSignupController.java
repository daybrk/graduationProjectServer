package com.example.graduationProjectServer.controller;

import com.example.graduationProjectServer.enity.*;
import com.example.graduationProjectServer.repository.RolesRepo;
import com.example.graduationProjectServer.repository.UserRoleRepo;
import com.example.graduationProjectServer.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
public class LoginSignupController {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserRoleRepo userRoleRepo;
    @Autowired
    private RolesRepo rolesRepo;

    @PostMapping("/registration")
    public ResponseEntity createNewUser(@RequestBody UserStructure user) {
        try {
            UserStructure userFromDb = userRepo.findByEmail(user.getEmail());
            if (userFromDb != null) {
                return ResponseEntity.badRequest().body("Пользователь с такими email уже сущетсвует");
            } else {
                userRepo.save(user);
                userRoleRepo.save(new UserRole(user, rolesRepo.getById(0L)));
                return ResponseEntity.ok("Регистрация прошла успешно");
            }
        } catch (Exception e) {
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
                        Roles role = rolesRepo.findById(userRoleRepo.findUserRoleByUserEmail(gettingUser).getRoleId().getId())
                                .orElseThrow(() -> new NoSuchElementException("Предложение не найдено"));
                        return new AuthResponse(role.getRole(), "");
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
