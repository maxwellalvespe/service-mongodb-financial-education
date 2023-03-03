package com.maxwell.mongodb.repository;

import com.maxwell.mongodb.model.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PaymentRepository extends MongoRepository<Payment,String> {
    List<Payment> findByStatus(String paid);
}
