package co.com.reto.reto.controller;

import co.com.reto.reto.domain.entities.User;
import co.com.reto.reto.services.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Validated
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;

    }
    @GetMapping("/{id}")
    public Mono<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping()
    public Mono<User> createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}/balance")
    public Mono<User> updateBalance(@PathVariable Long id, @RequestBody Double newBalance) {
        return userService.updateBalance(id, newBalance);
    }
}
