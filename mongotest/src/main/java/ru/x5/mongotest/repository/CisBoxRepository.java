package ru.x5.mongotest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.x5.mongotest.model.CisBox;

public interface CisBoxRepository extends MongoRepository<CisBox, String> {
}
