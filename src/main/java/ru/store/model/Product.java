package ru.store.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.store.enums.Category;

import java.time.LocalDateTime;

@Data
public class Product {
    private String productName;

    public Product(String productName, float price, boolean isAvailable, LocalDateTime deliveryDate, Category itemType) {
        this.productName = productName;
        this.price = price;
        this.isAvailable = isAvailable;
        this.deliveryDate = deliveryDate;
        this.itemType = itemType;
    }

    //Добавить разные валюты на стоимость
    private float price;
    private boolean isAvailable;
    private LocalDateTime deliveryDate;
    private Category itemType;

//    Добавить вес продукта
//    private double amount;
}
