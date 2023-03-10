package com.maxwell.mongodb.resource;

import com.maxwell.mongodb.model.Payment;
import com.maxwell.mongodb.model.PaymentDetails;
import com.maxwell.mongodb.model.Status;
import com.maxwell.mongodb.usecase.DetalharPagamento;
import com.maxwell.mongodb.usecase.RealizarPagamento;
import com.maxwell.mongodb.usecase.RemoverPagamento;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("payments")
@RequiredArgsConstructor
@Slf4j
public class PaymentResource {
    private final RealizarPagamento realizarPagamentoUseCase;
    private final DetalharPagamento detalharPagamentoUseCase;
    private final RemoverPagamento removerPagamentoUseCase;

    @PostMapping
    public ResponseEntity<List<Payment>> registrarPagamento(@RequestBody List<Payment> payments) {
        return new ResponseEntity<>(realizarPagamentoUseCase.efetivarPagamento(payments), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<PaymentDetails> detalharPagamento(@RequestParam Status status) {
        return new ResponseEntity<>(detalharPagamentoUseCase.detalhar(status), HttpStatus.OK);
    }

    @DeleteMapping
    public void removerBase() {
        removerPagamentoUseCase.removerTodosPagamentos();

    }


}
