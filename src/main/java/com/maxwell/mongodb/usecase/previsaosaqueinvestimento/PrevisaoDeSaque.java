package com.maxwell.mongodb.usecase.previsaosaqueinvestimento;

import com.maxwell.mongodb.model.Investment;
import com.maxwell.mongodb.repository.InvestimentRepository;
import com.maxwell.mongodb.usecase.ConsultaInvistimento;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PrevisaoDeSaque implements ConsultaInvistimento {


    private final InvestimentRepository repository;

    @Override
    public Map<String,String> consultarDataPrevistaParaLiberacaoDoInvestimento(String idInvestimento) {

      var investment=   repository.findById(idInvestimento).orElseThrow(() -> new IllegalArgumentException("Dados não localizados"));
      var retort = new HashMap<String,String>();
      retort.put("previsaoDeSaque",ChronoUnit.DAYS.addTo(investment.getDateInvestment(),investment.getSettlementTerm()).format(DateTimeFormatter.ofPattern("dd/MM/YYYY")));
        return retort;
    }
}
