package ru.store.enums;

import lombok.Getter;

public enum ProductType {
    PRODUCT("Продукты"),
    DRINK("Напитки");

    @Getter
    private String productType;

    ProductType(String productType) {
        this.productType = productType;
    }

}
