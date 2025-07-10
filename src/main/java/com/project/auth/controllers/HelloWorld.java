package com.project.auth.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/auth")
public class HelloWorld {
    @GetMapping("/hello")
    public ResponseEntity<String> getHelloWorld() {

        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }

}

