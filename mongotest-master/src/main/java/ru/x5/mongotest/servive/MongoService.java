package ru.x5.mongotest.servive;

import ru.x5.mongotest.model.*;

public interface MongoService {
    Product createProduct(Product product);

    CisPack createCisPack(CisPack cisPack);

    CisBlock createCisBlock(CisBlock cisBlock);

    CisBox createCisBox(CisBox cisBox);

    CisPallet createCisPallet(CisPallet cisPallet);

    Product findProductById(String productId);

    void updateProducerINNOfProduct(Product product);
//    List<GetProductsListResponse> getAllProduct();
//    Optional<CisBox> getCisByCisId(Long cisId);
////    void updateCis(CisBox cis);

//    void updateStatusOfCis(CisBox cisBox);
}
