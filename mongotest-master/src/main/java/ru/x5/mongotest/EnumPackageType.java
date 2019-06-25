package ru.x5.mongotest;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Getter
public enum EnumPackageType {
    BOX ("box"),
    BLOCK ("block"),
    PACK ("pack"),
    PALLET("pallet");

    private String packageType;

    EnumPackageType(String packageType) {
        this.packageType = packageType;
    }

    private static final Map<String, EnumPackageType> map;

    static {
        map = new HashMap<>();
        for (EnumPackageType packageType : EnumPackageType.values()) {
            map.put(packageType.packageType, packageType);
        }
    }

    @JsonCreator
    public static EnumPackageType findByDescription(String value) {
        return map.get(value.toLowerCase());
    }
}
