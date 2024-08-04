package co.com.reto.reto.services;

import co.com.reto.reto.domain.entities.Cashout;
import co.com.reto.reto.exceptions.UserNotFoundException;
import co.com.reto.reto.reposotories.CashautRepository;
import co.com.reto.reto.services.interfaces.ICashourtService;
import co.com.reto.reto.domain.entities.Cashout;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CashoutService implements ICashourtService {

    final private UserService userService;
    final private CashautRepository cashautRepository;

    public CashoutService(UserService userService, CashautRepository cashautRepository) {
        this.userService = userService;
        this.cashautRepository = cashautRepository;
    }
    @Override
    public Mono<Cashout> createCashout(Cashout cashout) {
        return userService.getUserById(cashout.getUserId())
                .flatMap(user -> {
                    if(user.getBalance() < cashout.getAmount()){
                        return Mono
                                .error(new UserNotFoundException("Saldo insuficiente"));
                    }
                    user
                            .setBalance(user
                                    .getBalance()-cashout
                                    .getAmount());
                    return userService.updateBalance(user.getId(), user.getBalance())
                            .flatMap(updatedUser -> cashautRepository.save(cashout));
                });
    }
}
