package com.automation.utils;

import java.util.Random;

public class EnumUtils<T extends Enum<T>> {

    public T[] valores;

    public EnumUtils(Class<T> token) {

        this.valores = token.getEnumConstants();
    }

    public T randomEnum() {

        Random random = new Random();

        return valores[random.nextInt(valores.length)];
    }
}