package com.maxwell.mongodb.usecase;

import com.maxwell.mongodb.model.Payment;

import java.util.List;

public interface RealizarPagamento {

    Payment efetivarPagamento(Payment payment);
    List<Payment> efetivarPagamento(List<Payment> payments);

}
