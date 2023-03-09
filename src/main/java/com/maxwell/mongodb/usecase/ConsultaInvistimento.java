package com.maxwell.mongodb.usecase;

import java.util.Map;

public interface ConsultaInvistimento {

    public Map<String,String> consultarDataPrevistaParaLiberacaoDoInvestimento(String idInvestimento);
}
