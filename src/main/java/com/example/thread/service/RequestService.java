package com.example.thread.service;

import org.springframework.stereotype.Service;

@Service
public class RequestService {

    public void pooh(long id) {
        long sum = id;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                sum += i * j;
            }
        }
    }
}
