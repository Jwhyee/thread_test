package com.example.thread.service;

import com.example.thread.domain.Request;
import com.example.thread.domain.RequestDto;
import com.example.thread.domain.RequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RequestService {

    private final RequestRepository repository;

    public Request saveRequest(RequestDto dto) {
        return repository.save(Request.builder()
                .title(dto.getRequestTitle())
                .savedDate(LocalDateTime.now())
                .build());
    }

    @Transactional(readOnly = true)
    public List<Request> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Map<Long, Request> listToMap() {
        return repository.findAll().stream()
                .collect(Collectors.toMap(Request::getId, Function.identity()));
    }
}
