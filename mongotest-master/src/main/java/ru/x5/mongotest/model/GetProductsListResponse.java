package ru.x5.mongotest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.x5.mongotest.model.dto.ProductDto;

import java.util.List;

/**
 * список продукции, содержащие id – идентификатор продукта, gtin - международный товарный идентификатор и producerINN – ИНН производителя.
 * total - количество продуктов в списке
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document("productList")
public class GetProductsListResponse {
    @JsonProperty("results")
    @DBRef
    private List<ProductDto> productDtoList;
    private Integer total;
    private Integer errorCode;
    private Boolean last;

}
