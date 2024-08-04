package co.com.reto.reto.services.interfaces;

import co.com.reto.reto.domain.entities.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;
import org.springframework.web.service.annotation.PutExchange;
import reactor.core.publisher.Mono;

public interface IUserService {
    Mono<User> getUserById(@PathVariable("id") Long userId) ;
    Mono<User> createUser(User user);
    Mono<User> updateBalance(Long id , Double newBalance);
}
