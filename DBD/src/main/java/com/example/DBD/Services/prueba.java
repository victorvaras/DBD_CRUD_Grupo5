package com.example.DBD.Services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class prueba {

    @GetMapping("/hello")
    public String HelloWorld(){
        return "hola mundo";
    }
}
