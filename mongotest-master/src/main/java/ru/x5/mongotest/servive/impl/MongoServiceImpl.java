package ru.x5.mongotest.servive.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import ru.x5.mongotest.model.Cis;
import ru.x5.mongotest.model.GetProductsListResponse;
import ru.x5.mongotest.model.Product;
import ru.x5.mongotest.repository.CisRepository;
import ru.x5.mongotest.repository.ProductListRepository;
import ru.x5.mongotest.repository.ProductRepository;
import ru.x5.mongotest.servive.MongoService;

import javax.management.Query;
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

//    @Override
//    public Optional<Cis> getCisByCisId(@PathVariable("cisId") String cisId){
//        return cisRepository.findCisByCisId(cisId);
//    }

    @Override
    public Optional<Product> findProductById(Long productId) {
        return productRepository.findById(productId);
    }
    @Override
    public void updateProduct(Product product) {
        Query searchQuery = new Query(Criteria.where("id").is(product.getProductId());
        mongoTemplate.upsert(searchQuery, Update.update("gtin", product.getGtin()).set("producerINN", product.getProducerINN())), Cis.class);
    }


//    @Override
////    public void addOrUpdateClickEvents(UserEvent userEvent) {
////        StoredEvent storedEvent = new StoredEvent(userEvent.getUserId(), userEvent.getType(), userEvent.getUrl(), userEvent.getBackground(),
////                System.currentTimeMillis());
////        try {
////            updateByMongo(userEvent, storedEvent);
////        } catch (DuplicateKeyException ex) {
////            log.error("Ошибка при обновлении: " + ex + ". Выполняем повторное обновление");
////            updateByMongo(userEvent, storedEvent);
////        }
////    }
////
////    private void updateByMongo(UserEvent userEvent, StoredEvent storedEvent) {
////        mongoOperations.upsert(new Query(Criteria.where("queryId").is(userEvent.getQueryId())),
////                new Update().push("storedEvents", storedEvent), UserEvents.class);
////    }

//    public class Product {
//        private Long productId;
//        private String gtin;
//        private String producerINN;
//    }

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
