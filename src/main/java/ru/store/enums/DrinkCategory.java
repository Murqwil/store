package ru.store.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum DrinkCategory implements Category {
    NORMAL("Обычная вода"),
    SODA("Газировка"),
    JUICE("Сок");

    private final String displayName;

    @Override
    public String getDisplayName() {
        return displayName;
    }
}
