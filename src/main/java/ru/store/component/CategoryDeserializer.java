package ru.store.component;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import ru.store.enums.Category;
import ru.store.enums.DrinkCategory;
import ru.store.enums.ProductCategory;

import java.io.IOException;

public class CategoryDeserializer extends JsonDeserializer<Category> {

    @Override
    public Category deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String value = p.getText().trim();

        for (ProductCategory product : ProductCategory.values()) {
            if (product.name().equalsIgnoreCase(value)) {
                return product;
            }
        }

        for (DrinkCategory drink : DrinkCategory.values()) {
            if (drink.name().equalsIgnoreCase(value)) {
                return drink;
            }
        }
        throw new IllegalArgumentException("Not found category");
    }
}