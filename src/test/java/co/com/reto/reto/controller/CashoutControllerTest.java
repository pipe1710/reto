package co.com.reto.reto.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CashoutControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void testMethodName() {
        webTestClient.get().uri("/cashout")
            .exchange()
            .expectStatus().isOk()
            .expectBody(String.class).isEqualTo("expected response");
    }
}
