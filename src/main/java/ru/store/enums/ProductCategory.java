package ru.store.enums;

public enum ProductCategory implements Category {
    MEAT("Мясо"),
    CHEESE("Сыр"),
    CHOCOLATE("Шоколад");

    private final String displayName;

    ProductCategory(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }
}
