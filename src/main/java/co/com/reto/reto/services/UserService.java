package co.com.reto.reto.services;

import co.com.reto.reto.domain.entities.User;
import co.com.reto.reto.exceptions.UserNotFoundException;
import co.com.reto.reto.reposotories.UserRepository;
import co.com.reto.reto.services.interfaces.IUserService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserService implements IUserService {

    final private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Mono<User> getUserById(Long userId) {
        return userRepository
                .findById(userId)
                .switchIfEmpty(Mono
                        .error(new UserNotFoundException("El usuario no existe")));
    }

    @Override
    public Mono<User> createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Mono<User> updateBalance(Long id, Double newBalance) {
        return userRepository
                .findById(id)
                .switchIfEmpty(Mono.error(new UserNotFoundException("El usuario no existe")))
                .flatMap(existingUser -> {
                    existingUser.setBalance(newBalance);
                    return userRepository.save(existingUser);
                });
    }
}
