package com.maxwell.mongodb.repository;

import com.maxwell.mongodb.model.Investment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InvestimentRepository extends MongoRepository<Investment,String> {
}
