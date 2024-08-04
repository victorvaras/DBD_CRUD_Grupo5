package com.example.DBD.Database;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sql2o.Sql2o;

@Configuration
public class Database {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/Prueba_final";
    private static final String USER = "postgres";
    private static final String PASS = "Admin";

    @Bean
    public Sql2o sql2o() {
        return new Sql2o(DB_URL, USER, PASS);
    }
}

