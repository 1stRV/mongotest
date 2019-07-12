package ru.x5.mongotest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CisPalletBoxBlockPack {
    private CisPallet cisPallet;
    private CisBox cisBox;
    private CisBlock cisBlock;
    private CisPack cisPack;
}