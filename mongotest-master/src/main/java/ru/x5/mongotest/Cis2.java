package ru.x5.mongotest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cis2 {
    String cisId;
    String status;
    EnumPackageType packageType;
    String sapHeaderId;
    String sapDetailId;
    @DBRef
    Cis parentCis;
}
