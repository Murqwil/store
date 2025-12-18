package ru.store.service.catalog.impl;

import lombok.Data;
import ru.store.enums.Category;
import ru.store.enums.DrinkCategory;
import ru.store.enums.ProductCategory;
import ru.store.model.Product;
import ru.store.service.catalog.CatalogService;

import java.util.*;

@Data
public class CatalogServiceImpl implements CatalogService {
    Map<Category, List<Product>> productByCategory = new HashMap<>();
    List<Product> allAssortment = new ArrayList<>();
    Scanner userAnswer = new Scanner(System.in);


    @Override
    public void getProductCatalog() {
        for(ProductCategory productCategory : ProductCategory.values()) {
            System.out.println(productCategory.ordinal() + " : " + productCategory);
        }
    }

    @Override
    public void getDrinkCatalog() {
        for(DrinkCategory drinkCategory : DrinkCategory.values()) {
            System.out.println(drinkCategory.ordinal() + " : " + drinkCategory);
        }
    }

    @Override
    public void addProduct(Product product) {
        allAssortment.add(product);
        Category category = product.getItemType();

        productByCategory.computeIfAbsent(category, k -> new ArrayList<>())
                .add(product);
    }

    @Override
    public void getProductByItemName(int userAnswer) {

    }

    @Override
    public void getDrinktByItemName(int userAnswer) {

    }
}


