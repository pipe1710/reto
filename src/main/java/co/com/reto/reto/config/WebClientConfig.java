package co.com.reto.reto.config;


import co.com.reto.reto.exceptions.Exception400Exception;
import co.com.reto.reto.exceptions.UserNotFoundException;
import co.com.reto.reto.services.interfaces.IUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.time.Duration;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient webClient(WebClient.Builder builder){
        return builder.baseUrl("http://localhost:8083")
                .defaultStatusHandler(HttpStatusCode::is4xxClientError, UserResponse -> {
                    return UserResponse.bodyToMono(String.class)
                            .flatMap(errorBody -> Mono.error(new Exception400Exception(errorBody)));
                })
                .defaultStatusHandler(HttpStatusCode::is5xxServerError, UserResponse -> {
                    return  UserResponse.
                            bodyToMono(String.class)
                            .retryWhen(Retry.backoff(3, Duration.ofSeconds(2)))
                            .flatMap(errorBody -> Mono.error(new UserNotFoundException(errorBody)));

                })
                .build();
    }


    @Bean
    public IUserService clienteRestClientBuild(WebClient client){
        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builderFor(WebClientAdapter.create(client)).build();
        return  factory.createClient(IUserService.class);
    }


}
