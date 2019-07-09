package ru.x5.mongotest.servive.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import ru.x5.mongotest.exception.CisDoesNotExistException;
import ru.x5.mongotest.exception.ProductDoesNotExistException;
import ru.x5.mongotest.model.*;
import ru.x5.mongotest.repository.*;
import ru.x5.mongotest.servive.MongoService;

import java.util.List;
import java.util.UUID;

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
    public void createCisPalletBoxBlockPack(CisPalletBoxBlockPack cisPalletBoxBlockPack) {
        for (int i = 0; i < 38; i++) {
        cisPackRepository.save(cisPalletBoxBlockPack.getCisPack());

        CisBlock cisBlock = cisPalletBoxBlockPack.getCisBlock();
        cisBlock.setCisId(cisPalletBoxBlockPack.getCisPack().getParentCisBlock().getCisId());
        cisBlockRepository.save(cisBlock);

        CisBox cisBox = cisPalletBoxBlockPack.getCisBox();
        cisBox.setCisId(cisPalletBoxBlockPack.getCisBlock().getParentCisBox().getCisId());
        cisBoxRepository.save(cisBox);

        CisPallet cisPallet = cisPalletBoxBlockPack.getCisPallet();
        cisPallet.setCisId(cisPalletBoxBlockPack.getCisBox().getParentCisPallet().getCisId());
        cisPalletRepository.save(cisPalletBoxBlockPack.getCisPallet());

        String status = "CIS_STATUS";
        List<Cis> cisPalletList = new ArrayList<>();
        for (int i = 0; i < 38; i++) {
            List<Cis> cisBoxList = new ArrayList<>();
            for (int j = 0; j < 25; j++) {
                List<Cis> cisBlockList = new ArrayList<>();
                for (int k = 0; k < 50; k++) {
                    List<Cis> cisPackList = new ArrayList<>();
                    for (int l = 0; l < 10; l++) {
                        cisPackList.add(Cis.builder().cisId(generateRandom(29)).status(status).build());
                    }
                    cisBlockList.add(Cis.builder().cisId(generateRandom(31)).cisList(cisPackList).status(status).build());
                }
                cisBoxList.add(Cis.builder().cisList(cisBlockList).cisId(generateRandom(29)).status(status).build());
            }
            cisPalletList.add(Cis.builder().cisList(cisBoxList).cisId(generateRandom(32)).status(status).build());
        }
        cisRepository.saveAll(cisPalletList);



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

//    @Override
//    public void updateStatusOfCisPalletAndDescendants(CisPallet cisPallet) {
//        CisPallet cisPalletDB = mongoTemplate.findOne(
//                Query.query(Criteria.where("_id").is(cisPallet.getCisId())), CisPallet.class);
//        if (cisPalletDB != null) {
//            cisPalletDB.setStatus(cisPallet.getStatus());
//            mongoTemplate.save(cisPallet, "CisPallet");
//
//            CisBox cisBoxDB = mongoTemplate.findOne(
//                    Query.query(Criteria.where("_id").is(cisPalletDB.getDescendantCisBox())), CisBox.class);
//            if (cisBoxDB != null) {
//                cisBoxDB.setStatus("disaggregation");
//                mongoTemplate.save(cisBoxDB, "CisBox");
//            } else {
//                throw new CisDoesNotExistException("CisBox с cisId = " + cisPalletDB.getDescendantCisBox().getCisId() + " не найден в БД!");
//            }
//            CisBlock cisBlockDB = mongoTemplate.findOne(
//                    Query.query(Criteria.where("_id").is(cisBoxDB.getDescendantCisBlock())), CisBlock.class);
//            if (cisBlockDB != null) {
//                cisBlockDB.setStatus("disaggregation");
//                mongoTemplate.save(cisBlockDB, "CisBlock");
//            } else {
//                throw new CisDoesNotExistException("CisBlock с cisId = " + cisBoxDB.getDescendantCisBlock().getCisId() + " не найден в БД!");
//            }
//            CisPack cisPackDB = mongoTemplate.findOne(
//                    Query.query(Criteria.where("_id").is(cisBlockDB.getDescendantCisPack())), CisPack.class);
//            if (cisPackDB != null) {
//                cisPackDB.setStatus("disaggregation");
//                mongoTemplate.save(cisPackDB, "CisPack");
//            } else {
//                throw new CisDoesNotExistException("CisPack с cisId = " + cisBlockDB.getDescendantCisPack().getCisId() + " не найден в БД!");
//            }
//        } else {
//            throw new CisDoesNotExistException("CisPallet с cisId = " + cisPallet.getCisId() + " не найден в БД!");
//        }
//    }

    public static String generateRandom(int lenght) {
        return UUID.randomUUID().toString().replace("-", "").substring(0, lenght);
    }
}
