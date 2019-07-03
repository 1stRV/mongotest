package ru.x5.mongotest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.x5.mongotest.model.Cis;

import java.util.Optional;
@Repository
public interface CisRepository extends MongoRepository<Cis, String> {
    Optional<Cis> findCisByCisId(String cisId);
}
