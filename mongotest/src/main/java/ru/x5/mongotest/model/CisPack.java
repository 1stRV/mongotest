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
@Document("CisPack")
public class CisPack {
    @Version
    private String version;

    @Id
    private String cisId;
    private EnumPackageType packageType;
    private String status;
    private String sapHeaderId;
    private String sapDetailId;

    @DBRef
    private CisBlock parentCisBlock;
}
