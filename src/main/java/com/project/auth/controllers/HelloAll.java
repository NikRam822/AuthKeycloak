package com.project.auth.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/all")
public class HelloAll {


    private static final Logger log = LoggerFactory.getLogger(HelloAll.class);

    @RequestMapping(value = "/hello")
    public ResponseEntity<String> hello() {
        log.info("Hello all");
        return new ResponseEntity<>("Hello all", HttpStatus.OK);
    }

}

