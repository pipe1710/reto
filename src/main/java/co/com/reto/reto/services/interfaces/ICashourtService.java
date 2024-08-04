package co.com.reto.reto.services.interfaces;

import co.com.reto.reto.domain.entities.Cashout;

import reactor.core.publisher.Mono;

public interface ICashourtService {

    Mono<Cashout> createCashout(Cashout cashout);
}
