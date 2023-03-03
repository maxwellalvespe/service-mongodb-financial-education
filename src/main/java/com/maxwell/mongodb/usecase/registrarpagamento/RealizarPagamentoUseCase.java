package com.maxwell.mongodb.usecase.registrarpagamento;

import com.maxwell.mongodb.model.Payment;
import com.maxwell.mongodb.model.Status;
import com.maxwell.mongodb.repository.PaymentRepository;
import com.maxwell.mongodb.usecase.RealizarPagamento;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class RealizarPagamentoUseCase implements RealizarPagamento {

    private final PaymentRepository repository;

    @Override
    public Payment efetivarPagamento(Payment payment) {
        return repository.save(payment);
    }

    @Override
    public List<Payment> efetivarPagamento(List<Payment> payments) {
        List<Payment> engagements = new ArrayList<>();
        for (Payment payment : payments) {
            if (payment.getStatus().equals(Status.UNPAID)) {
                log.info("Registrando pagamento do tipo :: {}", payment.getStatus());
                registerPaymentUnpaid(engagements, payment);
            } else {
                registerPaymentPaid(engagements, payment);
                log.info("Registrando pagamento do tipo :: {}", payment.getStatus());
            }
        }

        return engagements;
    }

    private void registerPaymentPaid(List<Payment> engagements, Payment payment) {
        engagements.add(repository.save(Payment.builder()
                .number(payment.getNumber())
                .status(payment.getStatus())
                .amountPaid(payment.getAmountPaid())
                .value(payment.getValue())
                .dateExpiration(payment.getDateExpiration())
                .datePayment(payment.getDatePayment())
                .build()));
    }

    private void registerPaymentUnpaid(List<Payment> engagements, Payment payment) {
        engagements.add(repository.save(Payment.builder()
                .number(payment.getNumber())
                .status(payment.getStatus())
                .value(payment.getValue())
                .updatedValue(payment.getUpdatedValue())
                .build()));
    }
}
