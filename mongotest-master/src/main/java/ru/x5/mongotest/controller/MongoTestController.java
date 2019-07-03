package ru.x5.mongotest.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.x5.mongotest.model.Cis;
import ru.x5.mongotest.model.GetProductsListResponse;
import ru.x5.mongotest.model.Product;
import ru.x5.mongotest.servive.impl.MongoServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MongoTestController {
    private final MongoServiceImpl mongoServiceImpl;

    @PostMapping(value = "/product")
    public void createProduct(@RequestBody Product product) {
        mongoServiceImpl.createProduct(product);
    }


//    @GetMapping(value = "/products")
//    public List<GetProductsListResponse> getAllProducts() {
//        return mongoServiceImpl.getAllProduct();
//    }

//    @GetMapping(value = "/{cisId}")
//    public Optional<Cis> getCisByCisid(@PathVariable("cisId") String cisId) {
//        return mongoServiceImpl.getCisByCisId(cisId);
//    }

    @GetMapping(value = "/{id}")
    public Optional<Product> getProductById(@PathVariable("id") Long productId) {
        return mongoServiceImpl.findProductById(productId);
    }

    @PostMapping(value = "/changeproduct")
    public void updateProduct(@RequestBody Product product) {
        mongoServiceImpl.createProduct(product);
    }


//    @PostMapping(value = "/cis}")
//    public void updateCis(@RequestBody Cis cis) {
//        return mongoServiceImpl.updateCis(cis);
//    }
}
