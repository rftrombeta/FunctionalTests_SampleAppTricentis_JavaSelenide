package com.automation.enums;

import lombok.Getter;

@Getter
public enum OptionPrice {

    SILVER("S"),
    GOLD("G"),
    PLATINUM("P"),
    ULTIMATE("U");

    private final String optionPrice;

    OptionPrice(String optionPrice) {

        this.optionPrice = optionPrice;
    }
}