package ru.store.enums;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ru.store.component.CategoryDeserializer;

@JsonDeserialize(using = CategoryDeserializer.class)
public interface Category {
    String getDisplayName();
}
