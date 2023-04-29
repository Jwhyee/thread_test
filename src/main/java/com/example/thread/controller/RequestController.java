package com.example.thread.controller;

import com.example.thread.domain.Request;
import com.example.thread.domain.RequestDto;
import com.example.thread.service.RequestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
@RequiredArgsConstructor
public class RequestController {

    private final RequestService requestService;

    private final Map<Long, Request> repo = new HashMap<>();
    private Long requestId = 1L;

    @PostMapping("/")
    public synchronized Request doMemoryRequest(RequestDto dto) {
        Request newReq = Request.builder()
                .id(requestId++)
                .title(dto.getRequestTitle())
                .savedDate(LocalDateTime.now())
                .build();
        repo.put(requestId, newReq);
        log.info("request = {}", newReq);
        return newReq;
    }

    @GetMapping("/data")
    public Object showMemoryData() {
        log.info("data_size={}", repo.size());
        return repo;
    }

    //    @PostMapping("/")
    public Request doRequest(RequestDto dto) {
        Request request = requestService.saveRequest(dto);
        log.info("request = {}", request);
        return request;
    }

    //    @GetMapping("/data")
    public Object showData() {
        Map<Long, Request> requestMap = requestService.listToMap();
        log.info("data_size={}", requestMap.size());
        return requestMap;
    }
}
