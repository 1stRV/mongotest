package ru.x5.mongotest.servive.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import ru.x5.mongotest.model.*;
import ru.x5.mongotest.repository.CisRepository;
import ru.x5.mongotest.repository.ProductListRepository;
import ru.x5.mongotest.repository.ProductRepository;
import ru.x5.mongotest.servive.MongoService;

import java.util.List;
import java.util.Optional;
@Slf4j
@Service
@RequiredArgsConstructor
public class MongoServiceImpl implements MongoService {
    private final ProductRepository productRepository;
    private final ProductListRepository productListRepository;
    private final CisRepository cisRepository;
    private final MongoOperations mongoOperations;

    @Override
    public void createProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void createCisBox(CisBox cisBox) {
        cisRepository.save(cisBox);
    }

    @Override
    public void createCisPack(CisPack cisPack) {

    }

    @Override
    public List<GetProductsListResponse> getAllProduct() {
        return productListRepository.findAll();
    }

    @Override
    public Product findProductById(String id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()){
            return product.orElse(new Product());
            log.debug("Из черного списка было успешно удалено слово = " + word);
        }
//        return productRepository.findById(id);
    }


//    public void deleteWord(String id, String word) {
//        Optional<Dictionary> dictionary = dictionaryRepository.findById(id);
//        if (dictionary.isPresent()) {
//            mongoOperations.upsert(new Query(Criteria.where("id").is(id)),
//                    new Update().pull("words", word).inc("wordCount", -1), Dictionary.class);
//            log.debug("Из черного списка было успешно удалено слово = " + word);
//        } else {
//            throw new DictionayDoesNotExistException("Словарь с id = " + id + " не найден!");
//        }
//    }
    @Override
    public void updateProducerINNOfProduct(Product product) {
        mongoOperations.upsert(new Query(Criteria.where("id").is(product.getId())),
                new Update().set("producerINN", product.getProducerINN()), Product.class);
    }

    @Override
    public void updateStatusOfCis(CisBox cisBox) {
        mongoOperations.upsert(new Query(Criteria.where("id").is(cisBox.getCisId())),
                new Update().set("status", cisBox.getStatus()), CisBox.class);
    }

    @Override
    public void createCisPallet(CisPallet cisPallet) {

    }


//    @Override
//    public Optional<CisBox> getCisByCisId(@PathVariable("cisId") String cisId){
//        return cisRepository.findCisByCisId(cisId);
//    }
//    @Override
//    public void updateProduct(Product product) {
//        Product storedProduct = new Product(product.getId(), product.getTin(),product.getProducerINN());
//        mongoOperations.upsert(new Query(Criteria.where("id").is(product.getId())),
//                new Update().push("storedProduct", storedProduct), Product.class);
//    }

//    @Override
//    public void updateProduct(Product product) {
//        Product storedProduct = new Product(product.getProductId(),product.getTin(),product.getProducerINN());
//        mongoOperations.upsert(new Query(Criteria.where("productId").is(product.getProductId())),
//                new Update().push("storedProduct", storedProduct), Product.class);
//    }

//    private void updateByMongo(Product product) {
//        mongoOperations.upsert(new Query(Criteria.where("queryId").is(userEvent.getQueryId())),
//                new Update().push("storedEvents", storedEvent), UserEvents.class);
//    }

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
//    public Optional<CisBox> getProductByCisId(@PathVariable("cisId") String cisId){
//        return cisRepository.findCisByCisId(cisId);
//    }

//    @Override
////    public void updateCis(CisBox cis) {
////        Query searchQuery = new Query(Criteria.where("id").is(cis.getCisId());
////        mongoTemplate.upsert(searchQuery, Update.update("sapHeaderId", cis.getSapHeaderId()).set("sapDetailId", cis.getSapDetailId()).set()), CisBox.class);
////    }

//    @Override
//    public void updateProduct(Product productDto) {
//        Query searchQuery = new Query(Criteria.where("id").is(cis.getCisId());
//        mongoTemplate.upsert(searchQuery, Update.update("sapHeaderId", cis.getSapHeaderId()).set("sapDetailId", cis.getSapDetailId()).set()), CisBox.class);
//    }

//    @Override
//    public void updateCis(CisBox cis) {
//        Query searchQuery = new Query(Criteria.where("id").is(cis.getCisId());
//        mongoTemplate.upsert(searchQuery, Update.update("sapHeaderId", cis.getSapHeaderId()).set("sapDetailId", cis.getSapDetailId()).set(...)), CisBox.class);
//    }

//    public class CisBox {
//        @Version
//        String cisId;
//        EnumPackageType packageType;
//        String status;
//        String sapHeaderId;
//        String sapDetailId;
//        List<CisBox> cisList;
//    }
}
