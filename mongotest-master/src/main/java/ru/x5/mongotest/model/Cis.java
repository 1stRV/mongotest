package ru.x5.mongotest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Version;
import ru.x5.mongotest.type.EnumPackageType;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cis {
    @Version
    String cisId;
    EnumPackageType packageType;
    String status;
    String sapHeaderId;
    String sapDetailId;
    List<Cis> cisList;
}
