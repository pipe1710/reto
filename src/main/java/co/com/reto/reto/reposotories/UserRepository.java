package co.com.reto.reto.reposotories;

import co.com.reto.reto.domain.entities.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserRepository extends ReactiveCrudRepository<User, Long> {

}
