package ru.x5.mongotest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Экземпляр продукции, содержащий id – идентификатор продукта, gtin - международный товарный идентификатор и producerINN – ИНН производителя.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document("Product")
public class Product {
    @Version
    private String version;

    @Id
    private String productId;
    private String tin;
    private String producerINN;
}
