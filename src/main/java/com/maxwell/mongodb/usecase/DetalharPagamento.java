package com.maxwell.mongodb.usecase;

import com.maxwell.mongodb.model.PaymentDetails;
import com.maxwell.mongodb.model.Status;

public interface DetalharPagamento {

    PaymentDetails detalhar(Status status);

}
