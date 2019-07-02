package ru.x5.mongotest.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.x5.mongotest.model.GetProductsListResponse;
import ru.x5.mongotest.model.dto.ProductDto;
import ru.x5.mongotest.servive.impl.MongoServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MongoTestController {
    private final MongoServiceImpl mongoServiceImpl;

        @PostMapping(value = "/product")
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        return mongoServiceImpl.createProduct(productDto);
    }


    @GetMapping(value = "/products")
    public List<GetProductsListResponse> getAllProducts() {
        return mongoServiceImpl.getAllProduct();
    }
}
