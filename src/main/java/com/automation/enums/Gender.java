package com.automation.enums;

import lombok.Getter;

@Getter
public enum Gender {

    FEMALE("F"),
    MALE("M");

    private final String gender;

    Gender(String gender) {

        this.gender = gender;
    }
}