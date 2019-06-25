package ru.x5.mongotest;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CisRepository extends MongoRepository<Cis, String > {
}
