package ru.store.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProductType {
    PRODUCT("Продукты", ProductCategory.values()),
    DRINK("Напитки", DrinkCategory.values());


    private final String productType;
    private final Category[] category;


    public Category getCategory(Category inputCategory) {
        for(Category c : category) {
            if(c.equals(inputCategory)) {
                return inputCategory;
            } else {
                return inputCategory;
            }
        }
        return null;
    }
}
