package com.maxwell.mongodb.usecase;

import com.maxwell.mongodb.model.Investment;

import java.util.Map;

public interface ConsultaInvistimento {

    public Map<String,String> consultarDataPrevistaParaLiberacaoDoInvestimento(String idInvestimento);
}
