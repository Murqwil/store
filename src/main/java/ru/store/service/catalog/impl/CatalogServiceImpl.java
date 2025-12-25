package ru.store.service.catalog.impl;

import ru.store.enums.Category;
import ru.store.enums.DrinkCategory;
import ru.store.enums.ProductCategory;
import ru.store.enums.ProductType;
import ru.store.model.Product;
import ru.store.service.catalog.CatalogService;

import java.util.*;
import java.util.function.Consumer;

public class CatalogServiceImpl implements CatalogService {
    private final Map<ProductType, Map<Category, List<Product>>> catalog =  new HashMap<>();
    private final List<Product> allAssortment = new ArrayList<>();

    private static final Map<Optional<ProductType>, Consumer<Void>> getListProductType = Map.of(
            Optional.empty(), v -> getAllCatalog(),
            Optional.of(ProductType.PRODUCT), v -> getProducts(),
            Optional.of(ProductType.DRINK), v -> getDrinks()
    );

    public static void getDrinks() {
        for(DrinkCategory drinkCategory : DrinkCategory.values()) {
            System.out.println(drinkCategory.ordinal() + " : " + drinkCategory);
        }
    }

    public static void getProducts() {
        for(ProductCategory productCategory : ProductCategory.values()) {
            System.out.println(productCategory.ordinal() + " : " + productCategory);
        }
    }

    public static void getAllCatalog() {
        getProducts();
        getDrinks();
    }

    @Override
    public void getCatalogByProductType(ProductType productType) {
        Optional<ProductType> key = Optional.ofNullable(productType);
        Consumer<Void> action = getListProductType.get(key);

        if (action != null) {
            action.accept(null);
        } else {
            getAllCatalog();
        }
    }

    @Override
    public void addProduct(Product product) {
        allAssortment.add(product);
        ProductType productType = ProductType.getProductType(product.getCategory());
        Category category = product.getCategory();

        catalog.computeIfAbsent(productType, k -> new HashMap<>())
                .computeIfAbsent(category, k -> new ArrayList<>())
                .add(product);
    }

    @Override
    public void getProductsByCategory(ProductType productType, int categoryChoice) {
            Category selectedCategory = productType.getCategoryByIndex(categoryChoice);

            allAssortment.stream()
                    .filter(product -> product.getCategory().equals(selectedCategory))
                    .forEach(System.out::println);
    }


    @Override
    public void getAllProducts() {
        allAssortment.forEach(System.out::println);
    }
}


