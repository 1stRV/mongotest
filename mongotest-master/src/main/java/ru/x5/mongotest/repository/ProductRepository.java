package ru.x5.mongotest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.x5.mongotest.model.Product;

import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product, Long > {
}
