package com.example.thread.controller;

import com.example.thread.domain.Request;
import com.example.thread.domain.RequestDto;
import com.example.thread.service.RequestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class RequestController {

    private final RequestService requestService;

    @PostMapping("/")
    public Request doRequest(RequestDto dto) {
        return requestService.saveRequest(dto);
    }

    @GetMapping("/data")
    public Object showData() {
        List<Request> findAllData = requestService.findAll();
        log.info("data_size={}", findAllData.size());
        return findAllData;
    }
}
