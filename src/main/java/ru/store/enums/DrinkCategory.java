package ru.store.enums;

public enum DrinkCategory implements Category {
    NORMAL("Обычная вода"),
    SODA("Газировка"),
    JUICE("Сок");

    private final String displayName;

    DrinkCategory(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }
}
