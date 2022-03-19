package controller;

import enity.UserRegistration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/registration")
public class RegistrationController {

    @PostMapping("")

    public ResponseEntity createNewUser(@RequestBody UserRegistration user) {
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
                return ResponseEntity.ok("Регистрация завершена");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

}
