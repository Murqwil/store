package ru.store.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.store.model.Product;

import java.util.Arrays;
import java.util.Optional;

@Getter
@AllArgsConstructor
public enum ProductType {
    PRODUCT("Продукты", ProductCategory.values()),
    DRINK("Напитки", DrinkCategory.values());

    private final String productType;
    private final Category[] categories;

    public Category getCategoryByIndex(int index) {
        if (index < 0 || index >= categories.length) {
            throw new IllegalArgumentException("Неверный индекс категории: " + index);
        }
        return categories[index];
    }

    public static ProductType getProductType(Category category) {
        return Arrays.stream(ProductType.values())
                .filter(it -> Arrays.stream(it.getCategories()).toList().contains(category))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Категория не найдена!"));
    }
}
