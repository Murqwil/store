package ru.store.service.catalog.impl;

import lombok.Data;
import ru.store.enums.Category;
import ru.store.enums.DrinkCategory;
import ru.store.enums.ProductCategory;
import ru.store.enums.ProductType;
import ru.store.model.Product;
import ru.store.service.catalog.CatalogService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Data
public class CatalogServiceImpl implements CatalogService {
    Map<ProductType, Map<Category, List<Product>>> catalog =  new HashMap<>();
    List<Product> allAssortment = new ArrayList<>();

    private static CatalogServiceImpl instance;

    public static CatalogServiceImpl getInstance() {
        if (instance == null) {
            instance = new CatalogServiceImpl();
        }
        return instance;
    }

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
    public void getCatalogByProductType(ProductType productType) {
        if (productType == null) {
            for(DrinkCategory drinkCategory : DrinkCategory.values()) {
                System.out.println(drinkCategory.ordinal() + " : " + drinkCategory);
            }
            for(ProductCategory productCategory : ProductCategory.values()) {
                System.out.println(productCategory.ordinal() + " : " + productCategory);
            }
        } else if (productType == ProductType.DRINK) {
            for(DrinkCategory drinkCategory : DrinkCategory.values()) {
                System.out.println(drinkCategory.ordinal() + " : " + drinkCategory);
            }
        } else {
            for(ProductCategory productCategory : ProductCategory.values()) {
                System.out.println(productCategory.ordinal() + " : " + productCategory);
            }
        }
    }

    @Override
    public void addProduct(Product product) {
        allAssortment.add(product);
//        Category category = product.getItemType();

//        productByCategory.computeIfAbsent(category, k -> new ArrayList<>())
//                .add(product);
    }

    @Override
    public void getProductByItemName(int userAnswer) {

    }

    @Override
    public void getDrinktByItemName(int userAnswer) {

    }
}


