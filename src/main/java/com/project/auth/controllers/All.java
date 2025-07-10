package com.project.auth.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/all")
public class All {

    @GetMapping("")
    public ResponseEntity<String> all() {
        return new ResponseEntity<>("All is well", HttpStatus.OK);
    }

}

