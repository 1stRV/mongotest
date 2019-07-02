package ru.x5.mongotest.servive.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.x5.mongotest.model.GetProductsListResponse;
import ru.x5.mongotest.model.dto.ProductDto;
import ru.x5.mongotest.repository.CisRepository;
import ru.x5.mongotest.repository.ProductListRepository;
import ru.x5.mongotest.repository.ProductRepository;
import ru.x5.mongotest.servive.MongoService;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class MongoServiceImpl implements MongoService {
    private final ProductRepository productRepository;
    private final ProductListRepository productListRepository;
    private final CisRepository cisRepository;

    @Override
    public ProductDto createProduct(ProductDto productDto) {

//    ProductDto productDto = new ProductDto(1L, "23456", "98765");
//            ProductDto productDto2 = new ProductDto(2L, "43", "09876");
//        List<ProductDto> productDtoList = Arrays.asList(productDto2);

        List<ProductDto> productDtoList = Arrays.asList(productDto);


//        productRepository.saveAll(productDtoList);
        GetProductsListResponse productsListResponse =
                GetProductsListResponse.builder().errorCode(232).last(true).total(10)
                .productDtoList(productDtoList)
                .build();

//        List<GetProductsListResponse> getProductsListResponseList = productListRepository.findAll();
//        System.out.println(getProductsListResponseList);
//        productListRepository.save(productsListResponse);
//        String status = "CIS_STATUS";
//        List<Cis> cisPalletList = new ArrayList<>();
//        for (int i = 0; i < 38; i++) {
//            List<Cis> cisBoxList = new ArrayList<>();
//            for (int j = 0; j < 25; j++) {
//                List<Cis> cisBlockList = new ArrayList<>();
//                for (int k = 0; k < 50; k++) {
//                    List<Cis> cisPackList = new ArrayList<>();
//                    for (int l = 0; l < 10; l++) {
//                        cisPackList.add(Cis.builder().cisId(generateRandom(29)).status(status).build());
//                    }
//                    cisBlockList.add(Cis.builder().cisId(generateRandom(31)).cisList(cisPackList).status(status).build());
//                }
//                cisBoxList.add(Cis.builder().cisList(cisBlockList).cisId(generateRandom(29)).status(status).build());
//            }
//            cisPalletList.add(Cis.builder().cisList(cisBoxList).cisId(generateRandom(32)).status(status).build());
//        }
//        cisRepository.saveAll(cisPalletList);
        productRepository.saveAll(productDtoList);
    }


    @Override
    public List<GetProductsListResponse> getAllProduct() {
        return productListRepository.findAll();
    }



    public static String generateRandom(int lenght) {
        byte[] array = new byte[lenght];
        new Random().nextBytes(array);
        return new String(array, Charset.forName("UTF-8"));
    }
}
