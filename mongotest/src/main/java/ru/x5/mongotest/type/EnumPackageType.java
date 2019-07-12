package ru.x5.mongotest.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum EnumPackageType {
    BOX("box"),
    BLOCK("block"),
    PACK("pack"),
    PALLET("pallet");
    private final String title;
}
