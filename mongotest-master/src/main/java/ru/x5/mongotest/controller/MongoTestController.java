package ru.x5.mongotest.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.x5.mongotest.model.*;
import ru.x5.mongotest.servive.impl.MongoServiceImpl;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MongoTestController {
    private final MongoServiceImpl mongoServiceImpl;

    @PostMapping(value = "/product")
    public Product createProduct(@RequestBody Product product) {
        return mongoServiceImpl.createProduct(product);
    }

    @PostMapping(value = "/cisPack")
    public CisPack createCisPack(@RequestBody CisPack cisPack) {
        return mongoServiceImpl.createCisPack(cisPack);
    }

    @PostMapping(value = "/cisBlock")
    public CisBlock createCisBlock(@RequestBody CisBlock cisBlock) {
        return mongoServiceImpl.createCisBlock(cisBlock);
    }

    @PostMapping(value = "/cisBox")
    public CisBox createCisBox(@RequestBody CisBox cisBox) {
        return mongoServiceImpl.createCisBox(cisBox);
    }

    @PostMapping(value = "/cisPallet")
    public CisPallet createCisPallet(@RequestBody CisPallet cisPallet) {
        return mongoServiceImpl.createCisPallet(cisPallet);
    }

    @GetMapping(value = "/{id}")
    public Product getProductById(@PathVariable("id") String id) {
        return mongoServiceImpl.findProductById(id);
    }

    @GetMapping(value = "/cisPack/{id}")
    public CisPack findCisPackByCisId(@PathVariable("id") String id) {
        return mongoServiceImpl.findCisPackByCisId(id);
    }

    @GetMapping(value = "/cisBlock/{id}")
    public CisBlock findCisBlockByCisId(@PathVariable("id") String id) {
        return mongoServiceImpl.findCisBlockkByCisId(id);
    }

    @GetMapping(value = "/cisBox/{id}")
    public CisBox findCisBoxByCisId(@PathVariable("id") String id) {
        return mongoServiceImpl.findCisBoxkByCisId(id);
    }

    @GetMapping(value = "/cisBox/{id}")
    public CisPallet findCisPalletByCisId(@PathVariable("id") String id) {
        return mongoServiceImpl.findCisPalletkByCisId(id);
    }

    @PostMapping(value = "/producerINN")
    public void updateProducerINNOfProduct(@RequestBody Product product) {
        mongoServiceImpl.updateProducerINNOfProduct(product);
    }

//    @PostMapping(value = "/status")
//    public void updateStatusOfCis(@RequestBody CisBox cisBox) {
//        mongoServiceImpl.updateStatusOfCis(cisBox);
//    }

//    @PostMapping(value = "/cis}")
//    public void updateCis(@RequestBody CisBox cis) {
//        return mongoServiceImpl.updateCis(cis);
//    }

    //    @GetMapping(value = "/products")
//    public List<GetProductsListResponse> getAllProducts() {
//        return mongoServiceImpl.getAllProduct();
//    }

//    @GetMapping(value = "/{cisId}")
//    public Optional<CisBox> getCisByCisid(@PathVariable("cisId") String cisId) {
//        return mongoServiceImpl.getCisByCisId(cisId);
//    }
}
