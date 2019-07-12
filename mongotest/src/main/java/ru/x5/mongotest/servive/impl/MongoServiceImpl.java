package ru.x5.mongotest.servive.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import ru.x5.mongotest.exception.CisDoesNotExistException;
import ru.x5.mongotest.exception.ProductDoesNotExistException;
import ru.x5.mongotest.model.*;
import ru.x5.mongotest.repository.*;
import ru.x5.mongotest.servive.MongoService;
import ru.x5.mongotest.type.EnumPackageType;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MongoServiceImpl implements MongoService {
    private final ProductRepository productRepository;
    private final CisPackRepository cisPackRepository;
    private final CisBlockRepository cisBlockRepository;
    private final CisBoxRepository cisBoxRepository;
    private final CisPalletRepository cisPalletRepository;
    private final CisRepository cisRepository;
    private final MongoTemplate mongoTemplate;

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
        return productRepository.findById(id).orElseThrow(() -> new ProductDoesNotExistException("Продукт с id = " + id + " не найден в БД!"));
    }

    @Override
    public CisPack findCisPackByCisId(String cisId) {
        return cisPackRepository.findById(cisId).orElseThrow(() -> new CisDoesNotExistException("CisPack с cisId = " + cisId + " не найден в БД"));
    }

    @Override
    public CisBlock findCisBlockByCisId(String cisId) {
        return cisBlockRepository.findById(cisId).orElseThrow(() -> new CisDoesNotExistException("CisBlock с cisId = " + cisId + " не найден в БД!"));
    }

    @Override
    public CisBox findCisBoxByCisId(String cisId) {
        return cisBoxRepository.findById(cisId).orElseThrow(() -> new CisDoesNotExistException("CisBox с cisId = " + cisId + " не найден в БД!"));
    }

    @Override
    public CisPallet findCisPalletByCisId(String cisId) {
        return cisPalletRepository.findById(cisId).orElseThrow(() -> new CisDoesNotExistException("CisPallet с cisId = " + cisId + " не найден в БД!"));
    }

    @Override
    public List<CisPack> findCisPackBySapHeaderId(String sapHeaderId) {
        List<CisPack> list = mongoTemplate.find(new Query(Criteria.where("sapHeaderId").is(sapHeaderId)), CisPack.class);
        if (!list.isEmpty()) {
            return list;
        } else {
            throw new CisDoesNotExistException("CisPack с sapHeaderId = " + sapHeaderId + " не найден в БД!");
        }
    }

    @Override
    public List<CisBlock> findCisBlockBySapHeaderId(String sapHeaderId) {
        List<CisBlock> list = mongoTemplate.find(new Query(Criteria.where("sapHeaderId").is(sapHeaderId)), CisBlock.class);
        if (!list.isEmpty()) {
            return list;
        } else {
            throw new CisDoesNotExistException("CisBlock с sapHeaderId = " + sapHeaderId + " не найден в БД!");
        }
    }

    @Override
    public List<CisBox> findCisBoxBySapHeaderId(String sapHeaderId) {
        List<CisBox> list = mongoTemplate.find(new Query(Criteria.where("sapHeaderId").is(sapHeaderId)), CisBox.class);
        if (!list.isEmpty()) {
            return list;
        } else {
            throw new CisDoesNotExistException("CisBox с sapHeaderId = " + sapHeaderId + " не найден в БД!");
        }
    }

    @Override
    public List<CisPallet> findCisPalletBySapHeaderId(String sapHeaderId) {
        List<CisPallet> list = mongoTemplate.find(new Query(Criteria.where("sapHeaderId").is(sapHeaderId)), CisPallet.class);
        if (!list.isEmpty()) {
            return list;
        } else {
            throw new CisDoesNotExistException("CisPallet с sapHeaderId = " + sapHeaderId + " не найден в БД!");
        }
    }

    @Override
    public void createCisPalletBoxBlockPackSeparate() {
        long startTime1 = System.currentTimeMillis();

        for (int f = 0; f < 100; f++) {
            List<CisPallet> cisPallets = new ArrayList<>();
            List<CisBox> cisBoxes = new ArrayList<>();
            List<CisBlock> cisBlocks = new ArrayList<>();
            List<CisPack> cisPacks = new ArrayList<>();
            long startTime2 = System.currentTimeMillis();
            for (int i = 0; i < 38; i++) {
                String randomCisPalletId = RandomStringUtils.randomAlphanumeric(32);
                String randomCisPalletStatus = RandomStringUtils.randomAlphanumeric(32);
                String randomCisPalletSapHeaderId = RandomStringUtils.randomAlphanumeric(32);
                String randomCisPalletSapDetailId = RandomStringUtils.randomAlphanumeric(32);
                CisPallet cisPallet = CisPallet.builder().cisId(randomCisPalletId).packageType(EnumPackageType.PALLET).status(randomCisPalletStatus).sapHeaderId(randomCisPalletSapHeaderId).sapDetailId(randomCisPalletSapDetailId).build();
                cisPallets.add(cisPallet);

                for (int j = 0; j < 25; j++) {
                    String randomCisBoxStatus = RandomStringUtils.randomAlphanumeric(29);
                    String randomCisBoxSapHeaderId = RandomStringUtils.randomAlphanumeric(29);
                    String randomCisBoxSapDetailId = RandomStringUtils.randomAlphanumeric(29);
                    String randomCisBoxId = RandomStringUtils.randomAlphanumeric(29);
                    CisBox cisBox = CisBox.builder().cisId(randomCisBoxId).packageType(EnumPackageType.BOX).status(randomCisBoxStatus).sapHeaderId(randomCisBoxSapHeaderId).sapDetailId(randomCisBoxSapDetailId).parentCisPallet(cisPallet).build();
                    cisBoxes.add(cisBox);

                    for (int k = 0; k < 50; k++) {
                        String randomCisBlockId = RandomStringUtils.randomAlphanumeric(31);
                        String randomCisBlockStatus = RandomStringUtils.randomAlphanumeric(31);
                        String randomCisBlockSapHeaderId = RandomStringUtils.randomAlphanumeric(31);
                        String randomCisBlockSapDetailId = RandomStringUtils.randomAlphanumeric(31);
                        CisBlock cisBlock = CisBlock.builder().cisId(randomCisBlockId).packageType(EnumPackageType.BLOCK).status(randomCisBlockStatus).sapHeaderId(randomCisBlockSapHeaderId).sapDetailId(randomCisBlockSapDetailId).parentCisBox(cisBox).build();
                        cisBlocks.add(cisBlock);

                        for (int l = 0; l < 10; l++) {
                            String randomCisPackStatus = RandomStringUtils.randomAlphanumeric(29);
                            String randomCisPackSapHeaderId = RandomStringUtils.randomAlphanumeric(29);
                            String randomCisPackSapDetailId = RandomStringUtils.randomAlphanumeric(29);
                            String randomCisPackId = RandomStringUtils.randomAlphanumeric(29);
                            CisPack cisPack = CisPack.builder().cisId(randomCisPackId).packageType(EnumPackageType.PACK).status(randomCisPackStatus).sapHeaderId(randomCisPackSapHeaderId).sapDetailId(randomCisPackSapDetailId).parentCisBlock(cisBlock).build();
                            cisPacks.add(cisPack);
                        }
                    }
                }
            }
            cisPackRepository.insert(cisPacks);
            cisBlockRepository.insert(cisBlocks);
            cisBoxRepository.insert(cisBoxes);
            cisPalletRepository.insert(cisPallets);
            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime2;
            log.info("в БД Сохранено 38 документов CisPallet за время = " + elapsedTime);
        }

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime1;
        log.info("в БД Сохранено 380 документов CisPallet за время = " + elapsedTime);
    }

    @Override
    public void updateStatusCisPack(CisPack cisPack) {
        CisPack cisPackDB = mongoTemplate.findOne(
                Query.query(Criteria.where("_id").is(cisPack.getCisId())), CisPack.class);
        if (cisPackDB != null) {
            cisPackDB.setStatus(cisPack.getStatus());
            mongoTemplate.save(cisPackDB, "CisPack");
        } else {
            throw new CisDoesNotExistException("CisPack с cisId = " + cisPack.getCisId() + " не найден в БД!");
        }
    }

    @Override
    public void updateStatusOfCisPackAndParents(CisPack cisPack) {
        CisPack cisPackDB = mongoTemplate.findOne(
                Query.query(Criteria.where("_id").is(cisPack.getCisId())), CisPack.class);
        if (cisPackDB != null) {
            cisPackDB.setStatus(cisPack.getStatus());
            mongoTemplate.save(cisPackDB, "CisPack");

            CisBlock cisBlockDB = mongoTemplate.findOne(
                    Query.query(Criteria.where("_id").is(cisPackDB.getParentCisBlock().getCisId())), CisBlock.class);
            if (cisBlockDB != null) {
                cisBlockDB.setStatus("disaggregation");
                mongoTemplate.save(cisBlockDB, "CisBlock");

                CisBox cisBoxDB = mongoTemplate.findOne(
                        Query.query(Criteria.where("_id").is(cisBlockDB.getParentCisBox().getCisId())), CisBox.class);
                if (cisBoxDB != null) {
                    cisBoxDB.setStatus("disaggregation");
                    mongoTemplate.save(cisBoxDB, "CisBox");

                    CisPallet cisPalletDB = mongoTemplate.findOne(
                            Query.query(Criteria.where("_id").is(cisBoxDB.getParentCisPallet().getCisId())), CisPallet.class);
                    if (cisPalletDB != null) {
                        cisPalletDB.setStatus("disaggregation");
                        mongoTemplate.save(cisPalletDB, "CisPallet");
                    } else {
                        throw new CisDoesNotExistException("CisPallet с cisId = " + cisBoxDB.getParentCisPallet().getCisId() + " не найден в БД!");
                    }
                } else {
                    throw new CisDoesNotExistException("CisBox с cisId = " + cisBlockDB.getParentCisBox().getCisId() + " не найден в БД!");
                }
            } else {
                throw new CisDoesNotExistException("CisBlock с cisId = " + cisPackDB.getParentCisBlock().getCisId() + " не найден в БД!");
            }
        } else {
            throw new CisDoesNotExistException("CisPack с cisId = " + cisPack.getCisId() + " не найден в БД!");
        }
    }

    @Override
    public void updateSapHeaderIdCisPack(CisPack cisPack) {
        CisPack cisPackDB = mongoTemplate.findOne(
                Query.query(Criteria.where("_id").is(cisPack.getCisId())), CisPack.class);
        if (cisPackDB != null) {
            cisPackDB.setSapHeaderId(cisPack.getSapHeaderId());
            mongoTemplate.save(cisPackDB, "CisPack");
        } else {
            throw new CisDoesNotExistException("CisPack с cisId = " + cisPack.getCisId() + " не найден в БД!");
        }
    }

    @Override
    public void updateSapDetailIdCisPack(CisPack cisPack) {
        CisPack cisPackDB = mongoTemplate.findOne(
                Query.query(Criteria.where("_id").is(cisPack.getCisId())), CisPack.class);
        if (cisPackDB != null) {
            cisPackDB.setSapDetailId(cisPack.getSapDetailId());
            mongoTemplate.save(cisPackDB, "CisPack");
        } else {
            throw new CisDoesNotExistException("CisPack с cisId = " + cisPack.getCisId() + " не найден в БД!");
        }
    }

    @Override
    public void createCisPalletBoxBlockPackOneCollection() {
        List<Cis> cisPalletList = new ArrayList<>();
        for (int i = 0; i < 38; i++) {
            List<Cis> cisBoxList = new ArrayList<>();
            for (int j = 0; j < 25; j++) {
                List<Cis> cisBlockList = new ArrayList<>();
                for (int k = 0; k < 50; k++) {
                    List<Cis> cisPackList = new ArrayList<>();
                    for (int l = 0; l < 10; l++) {
                        cisPackList.add(Cis.builder().cisId(RandomStringUtils.randomAlphanumeric(29)).packageType(EnumPackageType.PACK).status(RandomStringUtils.randomAlphanumeric(29)).build());
                    }
                    cisBlockList.add(Cis.builder().cisId(RandomStringUtils.randomAlphanumeric(31)).packageType(EnumPackageType.BLOCK).status(RandomStringUtils.randomAlphanumeric(31)).sapHeaderId(RandomStringUtils.randomAlphanumeric(31)).sapDetailId(RandomStringUtils.randomAlphanumeric(31)).cisList(cisPackList).build());
                }
                cisBoxList.add(Cis.builder().cisId(RandomStringUtils.randomAlphanumeric(29)).packageType(EnumPackageType.BOX).status(RandomStringUtils.randomAlphanumeric(29)).sapHeaderId(RandomStringUtils.randomAlphanumeric(29)).sapDetailId(RandomStringUtils.randomAlphanumeric(29)).cisList(cisBlockList).build());
            }
            cisPalletList.add(Cis.builder().cisId(RandomStringUtils.randomAlphanumeric(32)).packageType(EnumPackageType.PALLET).status(RandomStringUtils.randomAlphanumeric(32)).sapHeaderId(RandomStringUtils.randomAlphanumeric(32)).sapDetailId(RandomStringUtils.randomAlphanumeric(32)).cisList(cisBoxList).build());
        }
        cisRepository.insert(cisPalletList);
    }
}