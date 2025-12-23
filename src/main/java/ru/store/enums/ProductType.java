package ru.store.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.store.model.Product;

@Getter
@AllArgsConstructor
public enum ProductType {
    PRODUCT("Продукты", ProductCategory.values()),
    DRINK("Напитки", DrinkCategory.values());

    private final String productType;
    private final Category[] categories;

    public Category[] getCategory(Product product) {
        if (product.getProductType().equals(PRODUCT)) {
            return ProductType.PRODUCT.categories;
        } else {
            return ProductType.DRINK.categories;
        }
    }

    public Category getCategoryByIndex(int index) {
        if (index < 0 || index >= categories.length) {
            throw new IllegalArgumentException("Неверный индекс категории: " + index);
        }
        return categories[index];
    }
}
