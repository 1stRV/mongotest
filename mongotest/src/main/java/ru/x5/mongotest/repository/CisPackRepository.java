package ru.x5.mongotest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.x5.mongotest.model.CisPack;

public interface CisPackRepository extends MongoRepository<CisPack, String> {
}
