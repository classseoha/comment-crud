package com.example.commentcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CommentCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommentCrudApplication.class, args);
    }

}
