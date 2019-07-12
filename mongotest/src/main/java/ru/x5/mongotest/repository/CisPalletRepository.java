package ru.x5.mongotest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.x5.mongotest.model.CisPallet;

public interface CisPalletRepository extends MongoRepository<CisPallet, String> {
}
