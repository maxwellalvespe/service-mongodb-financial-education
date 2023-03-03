package com.maxwell.mongodb.usecase;

import com.maxwell.mongodb.model.Payment;
import com.maxwell.mongodb.model.PaymentDetails;

import java.util.List;

public interface DetalharPagamento {

    PaymentDetails detalhar();
}
