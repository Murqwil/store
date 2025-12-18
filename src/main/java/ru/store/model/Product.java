package ru.store.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.store.enums.Category;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Product {
    private String productName;
    //Добавить разные валюты на стоимость
    private float price;
    private boolean isAvailable;
    private LocalDateTime deliveryDate;
    private Category itemType;

//    Добавить вес продукта
//    private double amount;
}
