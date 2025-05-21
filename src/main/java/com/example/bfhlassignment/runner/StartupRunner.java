package com.example.bfhlassignment.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.bfhlassignment.service.ApiService;

@Component
public class StartupRunner implements CommandLineRunner {

    @Autowired
    private ApiService apiService;

    @Override
    public void run(String... args) {
        apiService.generateWebhook();
    }
}
