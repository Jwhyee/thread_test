package com.example.thread.service;

import com.example.thread.domain.Request;
import com.example.thread.domain.RequestDto;
import com.example.thread.domain.RequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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

    public List<Request> findAll() {
        return repository.findAll();
    }
}
