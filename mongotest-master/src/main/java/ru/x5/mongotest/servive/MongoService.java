package ru.x5.mongotest.servive;

import ru.x5.mongotest.model.GetProductsListResponse;
import ru.x5.mongotest.model.dto.ProductDto;

import java.util.List;

public interface MongoService {
    void createProduct(ProductDto productDto);
    List<GetProductsListResponse> getAllProduct();
}
