package com.maxwell.mongodb.usecase;

import com.maxwell.mongodb.model.Payment;
import com.maxwell.mongodb.model.PaymentDetails;
import com.maxwell.mongodb.model.Status;

import java.util.List;

public interface DetalharPagamento {

    PaymentDetails detalhar(Status status);

}
