package com.desafiobackendjr;

import com.desafiobackendjr.entity.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DesafioBackendJrApplicationTests {


    @Autowired
    private WebTestClient webTestClient;


    @Test
    void testCreateTodoSucess() {
        var todo = new Todo("todo 1","desc todo 1",false,1);
        webTestClient
                .post()
                .uri("/todo")
                .bodyValue(todo)
                .exchange()
                .expectStatus().isCreated()
                .expectBody()
                .jsonPath("$").isArray()
                .jsonPath("$.length()").isEqualTo(1)
                .jsonPath("$[0].name").isEqualTo(todo.getName())
                .jsonPath("$.[0].description").isEqualTo(todo.getDescription())
                .jsonPath("$.[0].realized").isEqualTo(todo.isRealized())
                .jsonPath("$.[0].priority").isEqualTo(todo.getPriority());

    }

    @Test
    void testCreateTodoFailure(){
        var todo = new Todo("","",false,0);
        webTestClient
                .post()
                .uri("/todo")
                .bodyValue(todo)
                .exchange()
                .expectStatus().isBadRequest();
    }

}
