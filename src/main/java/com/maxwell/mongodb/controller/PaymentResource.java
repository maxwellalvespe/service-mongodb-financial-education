package com.maxwell.mongodb.controller;

import com.maxwell.mongodb.model.Payment;
import com.maxwell.mongodb.repository.PaymentRepository;
import com.maxwell.mongodb.usecase.registrarPagamento.RealizarPagamentoUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("payments")
@RequiredArgsConstructor
@Slf4j
public class PaymentResource {

    private final PaymentRepository repository;

    private final RealizarPagamentoUseCase useCase;

    @PostMapping
    public ResponseEntity<List<Payment>> cadastrarPagamentos(@RequestBody List<Payment> payments) {
        return new ResponseEntity<>(useCase.efetivarPagamento(payments), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> historicoDePagamento() {

        List<Payment> parcelasPagas = repository.findByStatus("PAID");

        var totalPago = parcelasPagas.stream()
                .mapToDouble(e -> e.getAmountPaid().doubleValue()).sum();

        var totalEsperadoPelaFinanciadora = parcelasPagas.stream().mapToDouble( e -> e.getValue().doubleValue()
        ).sum();

        var response = new HashMap<String, Double>();
        response.put("totalPago", totalPago);
        response.put("esperado", totalEsperadoPelaFinanciadora);
        response.put("economiaGerada", totalEsperadoPelaFinanciadora - totalPago);
        response.put("parcelasPagas", (double) parcelasPagas.size());

        log.info("Registro salvo na base de dados  Valor pago R$ {}", totalPago);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping
    public void removerBase(){
        repository.deleteAll();
    }


}
