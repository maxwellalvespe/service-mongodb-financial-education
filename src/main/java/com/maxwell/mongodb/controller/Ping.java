package com.maxwell.mongodb.controller;

import com.maxwell.mongodb.model.Investment;
import com.maxwell.mongodb.repository.InvestimentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("ping")
@RequiredArgsConstructor
public class Ping {

    private final InvestimentRepository repository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> ping() {
        Map<String,Object> map = new HashMap<>();
        map.put("Status",HttpStatus.OK);
        map.put("Env",System.getenv());
        return new ResponseEntity<>(map, HttpStatus.OK
        );
    }

    @PostMapping("investimentos")
    public ResponseEntity<?> investiment(@RequestBody Investment request) {
        System.out.println("Applicattion online");
        var response = repository.save(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
