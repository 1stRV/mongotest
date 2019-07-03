package ru.x5.mongotest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.x5.mongotest.type.EnumPackageType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document("CisBox")
public class CisBox {
    @Version
    String version;

    String cisId;
    EnumPackageType packageType;
    String status;
    String sapHeaderId;
    String sapDetailId;

    @DBRef
    CisPallet parentCisPallet;
}
