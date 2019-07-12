package ru.x5.mongotest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.x5.mongotest.model.*;
import ru.x5.mongotest.servive.impl.MongoServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MongoTestController {
    private final MongoServiceImpl mongoServiceImpl;

    @PostMapping(value = "/createProduct")
    public Product createProduct(@RequestBody Product product) {
        return mongoServiceImpl.createProduct(product);
    }

    @PostMapping(value = "/createCisPack")
    public CisPack createCisPack(@RequestBody CisPack cisPack) {
        return mongoServiceImpl.createCisPack(cisPack);
    }

    @PostMapping(value = "/createCisBlock")
    public CisBlock createCisBlock(@RequestBody CisBlock cisBlock) {
        return mongoServiceImpl.createCisBlock(cisBlock);
    }

    @PostMapping(value = "/createCisBox")
    public CisBox createCisBox(@RequestBody CisBox cisBox) {
        return mongoServiceImpl.createCisBox(cisBox);
    }

    @PostMapping(value = "/createCisPallet")
    public CisPallet createCisPallet(@RequestBody CisPallet cisPallet) {
        return mongoServiceImpl.createCisPallet(cisPallet);
    }

    @GetMapping(value = "/getProductById/{cisId}")
    public Product getProductById(@PathVariable("cisId") String CisId) {
        return mongoServiceImpl.findProductById(CisId);
    }

    @GetMapping(value = "/findCisPackByCisId/{cisId}")
    public CisPack findCisPackByCisId(@PathVariable("cisId") String cisId) {
        return mongoServiceImpl.findCisPackByCisId(cisId);
    }

    @GetMapping(value = "/findCisBlockByCisId/{cisId}")
    public CisBlock findCisBlockByCisId(@PathVariable("cisId") String cisId) {
        return mongoServiceImpl.findCisBlockByCisId(cisId);
    }

    @GetMapping(value = "/findCisBoxByCisId/{cisId}")
    public CisBox findCisBoxByCisId(@PathVariable("cisId") String cisId) {
        return mongoServiceImpl.findCisBoxByCisId(cisId);
    }

    @GetMapping(value = "/findCisPalletByCisId/{cisId}")
    public CisPallet findCisPalletByCisId(@PathVariable("cisId") String cisId) {
        return mongoServiceImpl.findCisPalletByCisId(cisId);
    }

    @GetMapping(value = "/findCisPackBySapHeaderId/{sapHeaderId}")
    public List<CisPack> findCisPackBySapHeaderId(@PathVariable("sapHeaderId") String sapHeaderId) {
        return mongoServiceImpl.findCisPackBySapHeaderId(sapHeaderId);
    }

    @GetMapping(value = "/findCisBlockBySapHeaderId/{sapHeaderId}")
    public List<CisBlock> findCisBlockBySapHeaderId(@PathVariable("sapHeaderId") String sapHeaderId) {
        return mongoServiceImpl.findCisBlockBySapHeaderId(sapHeaderId);
    }

    @GetMapping(value = "/findCisBoxBySapHeaderId/{sapHeaderId}")
    public List<CisBox> findCisBoxBySapHeaderId(@PathVariable("sapHeaderId") String sapHeaderId) {
        return mongoServiceImpl.findCisBoxBySapHeaderId(sapHeaderId);
    }

    @GetMapping(value = "/findCisPalletBySapHeaderId/{sapHeaderId}")
    public List<CisPallet> findCisPalletBySapHeaderId(@PathVariable("sapHeaderId") String sapHeaderId) {
        return mongoServiceImpl.findCisPalletBySapHeaderId(sapHeaderId);
    }

    @PostMapping(value = "/createCisPalletBoxBlockPackSeparate")
    public ResponseEntity createCisPalletBoxBlockPackSeparate() {
        mongoServiceImpl.createCisPalletBoxBlockPackSeparate();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/updateStatusCisPack")
    public void updateStatusCisPack(@RequestBody CisPack cisPack) {
        mongoServiceImpl.updateStatusCisPack(cisPack);
    }

    @PostMapping(value = "/updateStatusOfCisPackAndParents")
    public void updateStatusOfCisPackAndParents(@RequestBody CisPack cisPack) {
        mongoServiceImpl.updateStatusOfCisPackAndParents(cisPack);
    }

    @PostMapping(value = "/updateSapHeaderIdCisPack")
    public void updateSapHeaderIdCisPack(@RequestBody CisPack cisPack) {
        mongoServiceImpl.updateSapHeaderIdCisPack(cisPack);
    }

    @PostMapping(value = "/updateSapDetailIdCisPack")
    public void updateSapDetailIdCisPack(@RequestBody CisPack cisPack) {
        mongoServiceImpl.updateSapDetailIdCisPack(cisPack);
    }

    @PostMapping(value = "/createCisPalletBoxBlockPackSeparate")
    public ResponseEntity createCisPalletBoxBlockPackOneCollection(){
        mongoServiceImpl.createCisPalletBoxBlockPackOneCollection();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
