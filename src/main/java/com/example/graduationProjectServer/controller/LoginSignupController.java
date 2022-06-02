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
    public AuthRegResponse createNewUser(@RequestBody UserStructure user) {
        try {
            UserStructure userFromDb = userRepo.findByEmail(user.getEmail());
            if (userFromDb != null) {
                return new AuthRegResponse(null, "Пользователь с такими email уже сущетсвует");
            } else {
                userRepo.save(user);
                userRoleRepo.save(new UserRole(user, rolesRepo.getById(0L)));
                return new AuthRegResponse(null, "");
            }
        } catch (Exception e) {
            return new AuthRegResponse(null, e.getMessage());
        }
    }
// endpoint login передаем емаил пароль
    @PostMapping("/login/{email}/{password}/{token}")
    // pathvariable позволяет передать значения из урл выше 
    public AuthRegResponse authorizationUser(@PathVariable(value = "email") String email,
                                             @PathVariable(value = "password") String password,
                                             @PathVariable(value = "token") String token) {
        try {
            if (email.equals("")) {
                return new AuthRegResponse(null, "Пустое поле с email");
            } else if (password.equals("")) {
                return new AuthRegResponse(null, "Пустое поле с паролем");
            } else {
                // gettinguser изначально пустой, потом мы кладем внего все данные пользователя
                UserStructure gettingUser = userRepo.findByEmail(email);
                if (gettingUser != null) {
                    // проверка на правильность введенного пароля
                    if (password.equals(gettingUser.getPassword())) {
                        Roles role = rolesRepo.findById(userRoleRepo.findUserRoleByUserEmail(gettingUser).getRoleId().getId())
                                .orElseThrow(() -> new NoSuchElementException("Предложение не найдено"));
                        gettingUser.setToken(token);
                        userRepo.save(gettingUser);
                        return new AuthRegResponse(role.getRole(), "");
                    } else {
                        return new AuthRegResponse(null, "Введён неверный пароль");
                    }
                    // если gettinguser = null то выводит это
                } else {
                    return new AuthRegResponse(null, "Пользователя с таким email не существует");
                }
            }
        } catch (Exception e) {
            return new AuthRegResponse(null, e.getMessage());
        }
    }

    @PostMapping("/logout/{email}")
    public ResponseEntity logout(@PathVariable(value = "email") String email) {
        try {
            UserStructure userFromDb = userRepo.findByEmail(email);
            userFromDb.setToken("");
            userRepo.save(userFromDb);
            return ResponseEntity.ok("Выход прошёл успешно");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }
}
