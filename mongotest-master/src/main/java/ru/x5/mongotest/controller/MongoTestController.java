package ru.x5.mongotest.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MongoTestController {
//    private final MongoServiceImpl mongoServiceImpl;

//    @PostMapping(value = "/product")
//    public Product createProduct(@RequestBody Product product) {
//        return productService.save(product);
//    }
@GetMapping(value = "/")
public String get() {
    return "cis";
}
}
