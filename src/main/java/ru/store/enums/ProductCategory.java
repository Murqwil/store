package ru.store.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ProductCategory implements Category {
    MEAT("Мясо"),
    CHEESE("Сыр"),
    CHOCOLATE("Шоколад");

    private final String displayName;

    @Override
    public String getDisplayName() {
        return displayName;
    }
}
