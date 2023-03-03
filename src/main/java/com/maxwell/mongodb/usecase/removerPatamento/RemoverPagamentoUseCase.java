package com.maxwell.mongodb.usecase.removerPatamento;

import com.maxwell.mongodb.repository.PaymentRepository;
import com.maxwell.mongodb.usecase.RemoverPagamento;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RemoverPagamentoUseCase implements RemoverPagamento {

    private final PaymentRepository repository;

    @Override
    public void removerPagamento(String id) {
        repository.deleteById(id);
    }

    @Override
    public void removerTodosPagamentos() {
        repository.deleteAll();
    }
}
