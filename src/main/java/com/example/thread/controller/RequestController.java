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
import java.util.Map;

@RestController
@Slf4j
@RequiredArgsConstructor
public class RequestController {

    private final RequestService requestService;

    @PostMapping("/")
    public Request doRequest(RequestDto dto) {
        Request request = requestService.saveRequest(dto);
        log.info("request = {}", request);
        return request;
    }

    @GetMapping("/data")
    public Object showData() {
        Map<Long, Request> requestMap = requestService.listToMap();
        log.info("data_size={}", requestMap.size());
        return requestMap;
    }
}
