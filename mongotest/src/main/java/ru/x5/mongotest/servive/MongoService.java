package ru.x5.mongotest.servive;

import ru.x5.mongotest.model.*;

import java.util.List;

public interface MongoService {
    Product createProduct(Product product);

    CisPack createCisPack(CisPack cisPack);

    CisBlock createCisBlock(CisBlock cisBlock);

    CisBox createCisBox(CisBox cisBox);

    CisPallet createCisPallet(CisPallet cisPallet);

    Product findProductById(String productId);

    CisPack findCisPackByCisId(String cisId);

    CisBlock findCisBlockByCisId(String cisId);

    CisBox findCisBoxByCisId(String cisId);

    CisPallet findCisPalletByCisId(String cisId);

    List<CisPack> findCisPackBySapHeaderId(String sapHeaderId);

    List<CisBlock> findCisBlockBySapHeaderId(String sapHeaderId);

    List<CisBox> findCisBoxBySapHeaderId(String sapHeaderId);

    List<CisPallet> findCisPalletBySapHeaderId(String sapHeaderId);

    void createCisPalletBoxBlockPackSeparate();

    void updateStatusCisPack(CisPack cisPack);

    void updateStatusOfCisPackAndParents(CisPack cisPack);

    void updateSapHeaderIdCisPack(CisPack cisPack);

    void updateSapDetailIdCisPack(CisPack cisPack);

    void createCisPalletBoxBlockPackOneCollection();
    //    void updateStatusOfCisPalletAndDescendants(CisPallet cisPallet);

}
