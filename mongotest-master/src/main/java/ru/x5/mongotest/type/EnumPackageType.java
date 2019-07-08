package ru.x5.mongotest.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Getter
public enum EnumPackageType {
    BOX("box"),
    BLOCK("block"),
    PACK("pack"),
    PALLET("pallet");
    private final String title;
}
