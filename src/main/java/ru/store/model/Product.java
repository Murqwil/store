package ru.store.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.store.enums.Category;
import ru.store.enums.ProductType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private String productName;
    //Добавить разные валюты на стоимость
    private float price;
    @JsonProperty("isAvailable")
    private boolean isAvailable;
    private ProductType productType;
    private Category category;

//    Добавить вес продукта
//    private double amount;
//    private LocalDateTime deliveryDate;

}
