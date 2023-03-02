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
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Investment {

    @Id
    private String id;
    private String userName;
    private LocalDate dateInvestment;

    private BigDecimal investedAmount;

    private Integer settlementTerm;

}
