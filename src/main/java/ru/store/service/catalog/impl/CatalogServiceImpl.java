package ru.store.service.catalog.impl;

import lombok.Data;
import ru.store.enums.Category;
import ru.store.enums.DrinkCategory;
import ru.store.enums.ProductCategory;
import ru.store.enums.ProductType;
import ru.store.model.Product;
import ru.store.service.catalog.CatalogService;

import java.util.*;

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
    public void getProductProductType() {
        for(ProductCategory productCategory : ProductCategory.values()) {
            System.out.println(productCategory.ordinal() + " : " + productCategory);
        }
    }

    @Override
    public void getDrinkProductType() {
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
        ProductType productType = product.getProductType();
        Category category = product.getCategory();

        catalog.computeIfAbsent(productType, k -> new HashMap<>())
                .computeIfAbsent(category, k -> new ArrayList<>())
                .add(product);
    }

    @Override
    public void getProductsByCategory(ProductType productType, int categoryChoice) {
        List<Category> categories;

        if (productType == ProductType.PRODUCT) {
            categories = Arrays.asList(ProductCategory.values());
        } else if (productType == ProductType.DRINK) {
            categories = Arrays.asList(DrinkCategory.values());
        } else {
            categories = Collections.emptyList();
        }

        if (categoryChoice < 0 || categoryChoice >= categories.size()) {
            System.out.println("Неверный выбор категории");
            return;
        }
        Category selectedCategory = categories.get(categoryChoice);

        allAssortment.stream()
                .filter(product -> product.getProductType() == productType)
                .filter(product -> product.getCategory().equals(selectedCategory))
                .forEach(System.out::println);
    }


    @Override
    public void getAllProducts() {
        instance.getAllAssortment().forEach(System.out::println);
    }
}


