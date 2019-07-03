package ru.x5.mongotest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class MongotestApplication {

//    @Autowired
//    ProductListRepository productListRepository;
//
//    @Autowired
//    ProductRepository productRepository;
//
//    @Autowired
//    CisRepository cisRepository;

    public static void main(String[] args) {
        SpringApplication.run(MongotestApplication.class, args);
    }

//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        Product productDto = new Product(1L, "23456", "98765");
//        Product productDto2 = new Product(2L, "43", "09876");
//        List<Product> productDtoList = Arrays.asList(productDto2);
//        productRepository.saveAll(productDtoList);
//        GetProductsListResponse productsListResponse =
//                GetProductsListResponse.builder().errorCode(232).last(true).total(10)
//                .productDtoList(productDtoList)
//                .build();
//        List<GetProductsListResponse> getProductsListResponseList = productListRepository.findAll();
//        System.out.println(getProductsListResponseList);
//        productListRepository.save(productsListResponse);
//        String status = "CIS_STATUS";
//        List<CisBox> cisPalletList = new ArrayList<>();
//        for (int i = 0; i < 38; i++) {
//            List<CisBox> cisBoxList = new ArrayList<>();
//            for (int j = 0; j < 25; j++) {
//                List<CisBox> cisBlockList = new ArrayList<>();
//                for (int k = 0; k < 50; k++) {
//                    List<CisBox> cisPackList = new ArrayList<>();
//                    for (int l = 0; l < 10; l++) {
//                        cisPackList.add(CisBox.builder().cisId(generateRandom(29)).status(status).build());
//                    }
//                    cisBlockList.add(CisBox.builder().cisId(generateRandom(31)).cisList(cisPackList).status(status).build());
//                }
//                cisBoxList.add(CisBox.builder().cisList(cisBlockList).cisId(generateRandom(29)).status(status).build());
//            }
//            cisPalletList.add(CisBox.builder().cisList(cisBoxList).cisId(generateRandom(32)).status(status).build());
//        }
//        cisRepository.saveAll(cisPalletList);
//    }

    public static String generateRandom(int lenght) {
        return UUID.randomUUID().toString().replace("-", "").substring(0, lenght);
    }
}
