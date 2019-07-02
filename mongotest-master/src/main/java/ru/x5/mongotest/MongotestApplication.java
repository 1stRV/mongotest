package ru.x5.mongotest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.x5.mongotest.model.Cis;
import ru.x5.mongotest.model.GetProductsListResponse;
import ru.x5.mongotest.model.dto.ProductDto;
import ru.x5.mongotest.repository.CisRepository;
import ru.x5.mongotest.repository.ProductListRepository;
import ru.x5.mongotest.repository.ProductRepository;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class MongotestApplication implements ApplicationRunner {

    @Autowired
    ProductListRepository productListRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CisRepository cisRepository;

    public static void main(String[] args) {
        SpringApplication.run(MongotestApplication.class, args);
    }

//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        ProductDto productDto = new ProductDto(1L, "23456", "98765");
//        ProductDto productDto2 = new ProductDto(2L, "43", "09876");
//        List<ProductDto> productDtoList = Arrays.asList(productDto2);
//        productRepository.saveAll(productDtoList);
//        GetProductsListResponse productsListResponse =
//                GetProductsListResponse.builder().errorCode(232).last(true).total(10)
//                .productDtoList(productDtoList)
//                .build();
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
//    }

//    public static String generateRandom(int lenght) {
//        byte[] array = new byte[lenght];
//        new Random().nextBytes(array);
//        return new String(array, Charset.forName("UTF-8"));
//    }
}
