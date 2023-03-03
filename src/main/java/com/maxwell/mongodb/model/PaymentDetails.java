package com.maxwell.mongodb.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDetails {

    private Integer totalInstallmentsPaid;
    private Double paymentEffective;

    private BigDecimal effectiveEconomy;

    private BigDecimal valueExpectedFinance;

}
