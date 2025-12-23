package ru.store.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProductType {
    PRODUCT("Продукты"),
    DRINK("Напитки");

    private final String productType;

}
