package com.maxwell.mongodb.usecase.detalharpagamento;

import com.maxwell.mongodb.model.Payment;
import com.maxwell.mongodb.model.PaymentDetails;
import com.maxwell.mongodb.model.Status;
import com.maxwell.mongodb.repository.PaymentRepository;
import com.maxwell.mongodb.usecase.DetalharPagamento;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
public class DetalharPagamentoUseCase implements DetalharPagamento {

    private final PaymentRepository repository;

    @Override
    public PaymentDetails detalhar() {
        List<Payment> parcelasPagas = repository.findAll();

        var pendente = parcelasPagas.stream().filter(f -> f.getStatus().equals(Status.UNPAID))
                .collect(Collectors.toList());

        var pagas = parcelasPagas.stream().filter(f -> f.getStatus().equals(Status.PAID)).toList();

        var totalPago = pagas.stream()
                .mapToDouble(Payment::getAmountPaid)
                .sum();

        var totalEsperadoPelaFinanciadora = pagas.stream().mapToDouble(e -> e.getValue().doubleValue()
        ).sum();


        if (pendente.size() > 1) {
            return PaymentDetails.builder().effectiveEconomy(BigDecimal.valueOf(totalEsperadoPelaFinanciadora - totalPago))
                    .paymentEffective(getPaymentEffective(pendente, totalPago))
                    .valueExpectedFinance(BigDecimal.valueOf(totalEsperadoPelaFinanciadora))
                    .totalInstallmentsPaid(pendente.size())
                    .build();
        }
        return PaymentDetails.builder()
                .effectiveEconomy(BigDecimal.valueOf(totalEsperadoPelaFinanciadora - totalPago))
                .paymentEffective(getPaymentEffective(pendente, totalPago))
                .valueExpectedFinance(BigDecimal.valueOf(totalEsperadoPelaFinanciadora))
                .totalInstallmentsPaid(pagas.size())
                .build();
    }

    private static Double getPaymentEffective(List<Payment> pendente, double totalPago) {
        return nonNull(totalPago) ? totalPago : pendente.stream().mapToDouble(p -> p.getUpdatedValue().doubleValue()).sum();
    }
}
