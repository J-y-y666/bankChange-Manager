package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SmallChangeService {

    private double balance = 0;
    private StringBuilder details = new StringBuilder();

    private List<Map<String, Object>> transactions = new ArrayList<>();

    public String income(double amount) {
        balance += amount;
        String record = String.format("收益入账 +%.2f %s %.2f",
                amount, new Date(), balance);
        details.append(record).append("\n");

        Map<String, Object> tx = new HashMap<>();
        tx.put("type", "INCOME");
        tx.put("amount", amount);
        tx.put("time", new Date());
        transactions.add(tx);

        return record;
    }

    public String outcome(double amount) {

        balance -= amount;
        details.append(String.format("消费 +%.2f %s %.2f\n",
                amount, new Date(), balance));
        return "消费成功";
    }

    public double getBalance() {
        return balance;
    }


}
