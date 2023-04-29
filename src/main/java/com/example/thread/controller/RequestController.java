package com.example.thread.controller;

import com.example.thread.service.RequestService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
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

    Map<Long, RequestDto> repo = new HashMap<>();
    private Long requestId = 1L;

    @Getter @Setter
    public static class RequestDto {
        private Long requestId;
        private String requestTitle;
        private LocalDateTime savedDate;

        @Override
        public String toString() {
            return "RequestDto{" +
                    "requestId=" + requestId +
                    ", savedDate=" + savedDate +
                    '}';
        }
    }

    @PostMapping("/")
    public RequestDto doRequest(RequestDto dto) {
        dto.setSavedDate(LocalDateTime.now());
        repo.put(requestId++, dto);
        dto.setRequestId(requestId);
        requestService.pooh(requestId);
        log.info("dto={}", dto);
        return dto;
    }

    @GetMapping("/data")
    public Object showData() {
        log.info("repo.size()={}", repo.size());
        return repo;
    }
}
