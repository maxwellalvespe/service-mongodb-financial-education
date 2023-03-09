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

@Service
@RequiredArgsConstructor
public class DetalharPagamentoUseCase implements DetalharPagamento {

    private final PaymentRepository repository;

    @Override
    public PaymentDetails detalhar(Status status) {
        List<Payment> parcelas = repository.findAll();
        return getPaymentDetails(parcelas, status);
    }

    private PaymentDetails getPaymentDetails(List<Payment> parcelas, Status status) {

        var registros = parcelas.stream().filter(f -> f.getStatus().equals(status))
                .toList();


        var quantidade = registros.size();
        var valorEsperado = registros.stream().map(Payment::getValue)
                .mapToDouble(BigDecimal::doubleValue)
                .sum();

        var paymentDetails = PaymentDetails.builder()
                .totalInstallmentsPaid(quantidade)
                .valueExpectedFinance(getFormat(valorEsperado))
                .build();
        if (status.equals(Status.PAID)) {
            var valorPago = registros.stream().map(Payment::getAmountPaid).mapToDouble(Double::doubleValue).sum();
            paymentDetails.setPaymentEffective(getFormat(valorPago));
            paymentDetails.setEffectiveEconomy(getFormat(valorEsperado - valorPago));
        }else {
            var pendente = registros.stream().map(Payment::getUpdatedValue).mapToDouble(BigDecimal::doubleValue).sum();
            paymentDetails.setValueUnpaid(getFormat(pendente));
            paymentDetails.setPaymentEffective(getFormat(valorEsperado-pendente));

        }
        return paymentDetails;

    }

    private String getFormat(Double value) {
        return String.format("R$ %.2f", value);
    }
}
