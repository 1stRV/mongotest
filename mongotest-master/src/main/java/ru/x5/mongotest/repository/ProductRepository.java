package ru.x5.mongotest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.x5.mongotest.model.dto.ProductDto;

public interface ProductRepository extends MongoRepository<ProductDto, String > {
}
