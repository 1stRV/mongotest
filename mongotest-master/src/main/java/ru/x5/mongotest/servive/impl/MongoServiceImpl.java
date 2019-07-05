package ru.x5.mongotest.servive.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import ru.x5.mongotest.exception.ProductDoesNotExistException;
import ru.x5.mongotest.model.*;
import ru.x5.mongotest.repository.*;
import ru.x5.mongotest.servive.MongoService;
import org.springframework.data.mongodb.core.query.Query;

@Slf4j
@Service
@RequiredArgsConstructor
public class MongoServiceImpl implements MongoService {
    private final ProductRepository productRepository;
    private final CisPackRepository cisPackRepository;
    private final CisBlockRepository cisBlockRepository;
    private final CisBoxRepository cisBoxRepository;
    private final CisPalletRepository cisPalletRepository;


    private final MongoOperations mongoOperations;

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public CisPack createCisPack(CisPack cisPack) {
        return cisPackRepository.save(cisPack);
    }

    @Override
    public CisBlock createCisBlock(CisBlock cisBlock) {
        return cisBlockRepository.save(cisBlock);
    }

    @Override
    public CisBox createCisBox(CisBox cisBox) {
        return cisBoxRepository.save(cisBox);
    }

    @Override
    public CisPallet createCisPallet(CisPallet cisPallet) {
        return cisPalletRepository.save(cisPallet);
    }

    @Override
    public Product findProductById(String id) {
        return productRepository.findById(id).orElseThrow(() -> new ProductDoesNotExistException("Продукт с id = " + id + " не найден!"));
    }

    @Override
    public void updateProducerINNOfProduct(Product product) {
        mongoOperations.upsert(new Query(Criteria.where("id").is(product.getId())),
                new Update().set("producerINN", product.getProducerINN()), Product.class);
    }

//    @Override
//    public void updateStatusOfCis(CisBox cisBox) {
//        mongoOperations.upsert(new Query(Criteria.where("id").is(cisBox.getCisId())),
//                new Update().set("status", cisBox.getStatus()), CisBox.class);
//    }


//    @Override
//    public Dictionary importDictionary(String name, List<String> words) {
//        if (!name.isEmpty() && !words.isEmpty()) {
//            Dictionary dictionary = new Dictionary();
//            dictionary.setName(name);
//            dictionary.setWords(words);
//            dictionary.setWordCount(words.size());
//            dictionary.setUpdated(LocalDateTime.now());
//            try {
//                return dictionaryRepository.save(dictionary);
//            } catch (DuplicateKeyException ex) {
//                throw new DictionaryUniqueNameException("Словарь с именем " + name + " уже существует!");
//            }
//        } else {
//            if (name.isEmpty()){
//                throw new DictionaryDataException("Наименование словаря не заполнено!");
//            } else {
//                throw new DictionaryDataException("Загружаемый файл пуст или вы пытаетесь згрузить файл с не поддерживаемой кодировкой!");
//            }
//        }
//    }


//    @Override
//    public List<GetProductsListResponse> getAllProduct() {
//        return productListRepository.findAll();
//    }
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
