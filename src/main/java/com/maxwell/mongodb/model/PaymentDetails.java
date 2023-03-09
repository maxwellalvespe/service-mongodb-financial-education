package com.maxwell.mongodb.model;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    private String paymentEffective;
    private String effectiveEconomy;
    private String valueExpectedFinance;

    private String valueUnpaid;

}
