package com.example.demo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class PostsController {

    @PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Mono<String> create(@RequestPart("ids") List<Long> ids) {
        return Mono.just(ids.toString());
    }

    @ExceptionHandler(Exception.class)
    public void handleException(Exception e) {
        e.printStackTrace();
    }
}
