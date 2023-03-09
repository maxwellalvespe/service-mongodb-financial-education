package com.maxwell.mongodb.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
