package com.maxwell.mongodb.resource;

import com.maxwell.mongodb.model.Investment;
import com.maxwell.mongodb.repository.InvestimentRepository;
import com.maxwell.mongodb.usecase.previsaosaqueinvestimento.PrevisaoDeSaque;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("investimentos")
@RequiredArgsConstructor
public class Investimento {

    private final InvestimentRepository repository;

    private final PrevisaoDeSaque previsaoDeSaque;

    @PostMapping
    public ResponseEntity<?> investiment(@RequestBody Investment request) {
        var response = repository.save(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<?>>findAll(){
        return new ResponseEntity<>(repository.findAll(),HttpStatus.OK);
    }

    @GetMapping("{invest}")
    public ResponseEntity<?> previsaoDeSaque(@PathVariable String invest){
        return  new ResponseEntity<>(previsaoDeSaque.consultarDataPrevistaParaLiberacaoDoInvestimento(invest),HttpStatus.OK);
    }
}
