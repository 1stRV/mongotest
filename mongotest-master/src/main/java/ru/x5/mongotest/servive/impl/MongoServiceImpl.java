package ru.x5.mongotest.servive.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import ru.x5.mongotest.model.Cis;
import ru.x5.mongotest.model.GetProductsListResponse;
import ru.x5.mongotest.model.Product;
import ru.x5.mongotest.repository.CisRepository;
import ru.x5.mongotest.repository.ProductListRepository;
import ru.x5.mongotest.repository.ProductRepository;
import ru.x5.mongotest.servive.MongoService;

import java.nio.charset.Charset;
import java.util.*;

@Service
@RequiredArgsConstructor
public class MongoServiceImpl implements MongoService {
    private final ProductRepository productRepository;
    private final ProductListRepository productListRepository;
    private final CisRepository cisRepository;
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void createProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<GetProductsListResponse> getAllProduct() {
        return productListRepository.findAll();
    }

    @Override
    public Optional<Cis> getCisByCisId(@PathVariable("cisId") String cisId){
        return cisRepository.findCisByCisId(cisId);
    }

//    @Override
//    public Optional<Cis> getProductByCisId(@PathVariable("cisId") String cisId){
//        return cisRepository.findCisByCisId(cisId);
//    }

//    @Override
////    public void updateCis(Cis cis) {
////        Query searchQuery = new Query(Criteria.where("id").is(cis.getCisId());
////        mongoTemplate.upsert(searchQuery, Update.update("sapHeaderId", cis.getSapHeaderId()).set("sapDetailId", cis.getSapDetailId()).set()), Cis.class);
////    }

//    @Override
//    public void updateProduct(Product productDto) {
//        Query searchQuery = new Query(Criteria.where("id").is(cis.getCisId());
//        mongoTemplate.upsert(searchQuery, Update.update("sapHeaderId", cis.getSapHeaderId()).set("sapDetailId", cis.getSapDetailId()).set()), Cis.class);
//    }

//    @Override
//    public void updateCis(Cis cis) {
//        Query searchQuery = new Query(Criteria.where("id").is(cis.getCisId());
//        mongoTemplate.upsert(searchQuery, Update.update("sapHeaderId", cis.getSapHeaderId()).set("sapDetailId", cis.getSapDetailId()).set(...)), Cis.class);
//    }

//    public class Cis {
//        @Version
//        String cisId;
//        EnumPackageType packageType;
//        String status;
//        String sapHeaderId;
//        String sapDetailId;
//        List<Cis> cisList;
//    }
}
