package com.automation.enums;

import lombok.Getter;

@Getter
public enum Hobbies {

    SPEEDING("SP"),
    BUNGEEJUNMPING("BJ"),
    CLIFFDIVING("CD"),
    SKYDIVING("SD"),
    OTHER("O");


    private final String hobbies;

    Hobbies(String hobbies) {

        this.hobbies = hobbies;
    }
}