package ru.store.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.store.enums.Category;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private String productName;
    private float price;
    private Category category;
    @JsonProperty("isAvailable")
    private boolean isAvailable;

}
