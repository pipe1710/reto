package co.com.reto.reto.reposotories;

import co.com.reto.reto.domain.entities.Cashout;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CashautRepository extends ReactiveCrudRepository<Cashout, Long> {
}
