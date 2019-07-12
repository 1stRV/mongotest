package ru.x5.mongotest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.x5.mongotest.model.Cis;

public interface CisRepository extends MongoRepository<Cis, String > {
}

