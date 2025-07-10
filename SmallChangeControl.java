package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SmallChangeControl {
    private final SmallChangeService service;


    public SmallChangeControl(SmallChangeService service) {
        this.service = service;
    }

    @PostMapping("/income")
    public String income(@RequestParam double amount) {
        return service.income(amount);
    }

    @PostMapping("/outcome")
    public String outcome(@RequestParam double amount) {
        return service.outcome(amount);
    }

    @GetMapping("/health")
    public String health() {
        return "Service is UP! Balance: " + service.getBalance();
    }


    @GetMapping("/balance")
    public String getBalance() {
        double balance = service.getBalance();
        return String.format("当前余额：%.2f", balance);
    }


}
