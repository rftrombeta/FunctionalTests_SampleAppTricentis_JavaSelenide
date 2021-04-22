package com.automation.enums;

import lombok.Getter;

@Getter
public enum Months {

    JANUARY(1,"January"),
    FEBRUARY(2, "February"),
    MARCH(3, "March"),
    APRIL(4, "April"),
    MAY(5, "May"),
    JUNE(6, "June"),
    JULY(7, "July"),
    AUGUST(8, "August"),
    SEPTEMBER(9, "September"),
    OCTOBER(10, "October"),
    NOVEMBER(11, "November"),
    DECEMBER(12, "December");

    private final Integer month;

    private final String monthName;

    Months(Integer month, String monthName) {

        this.month = month;
        this.monthName = monthName;
    }
}