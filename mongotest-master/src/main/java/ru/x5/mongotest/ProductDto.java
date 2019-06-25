package ru.x5.mongotest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Экземпляр продукции, содержащий id – идентификатор продукта, gtin - международный товарный идентификатор и producerINN – ИНН производителя.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document("Product")
public class ProductDto {
    private Long id;
    private String gtin;
    private String producerINN;

}
