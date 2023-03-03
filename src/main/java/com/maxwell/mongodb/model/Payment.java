package com.maxwell.mongodb.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;

@Document
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    @Id
    private String id;
    private int number;
    private Status status;
    private BigDecimal value;
    private BigDecimal updatedValue;
    private BigDecimal amountPaid;
    private LocalDate dateExpiration;
    private LocalDate datePayment;

}
