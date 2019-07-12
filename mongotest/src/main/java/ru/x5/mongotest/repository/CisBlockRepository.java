package ru.x5.mongotest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.x5.mongotest.model.CisBlock;

public interface CisBlockRepository extends MongoRepository<CisBlock, String> {
}
