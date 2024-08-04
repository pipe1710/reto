package co.com.reto.reto.controller;

import co.com.reto.reto.domain.entities.Cashout;
import co.com.reto.reto.exceptions.UserNotFoundException;
import co.com.reto.reto.reposotories.CashautRepository;
import co.com.reto.reto.services.CashoutService;
import co.com.reto.reto.services.UserService;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Validated
@RestController
@RequestMapping("/cashout")
public class CashoutController {

    final private CashoutService cashoutService;

    public CashoutController(UserService userService, CashautRepository cashautRepository, CashoutService cashoutService) {
        this.cashoutService = cashoutService;
    }

    @PostMapping("")
    public Mono<Cashout> createCashout(@Valid  @RequestBody Cashout cashout){
        return cashoutService.createCashout(cashout);
    }

}

