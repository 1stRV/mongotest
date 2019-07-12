package ru.x5.mongotest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.x5.mongotest.model.GetProductsListResponse;

public interface ProductListRepository extends MongoRepository<GetProductsListResponse, String > {
}
