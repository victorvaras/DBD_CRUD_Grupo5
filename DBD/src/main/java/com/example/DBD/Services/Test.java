package com.example.DBD.Services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

    @GetMapping("hola")
    public String hola() {
        return "hola";
    }
}
