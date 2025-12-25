package ru.store.configuration;

import lombok.Getter;
import ru.store.service.cart.CartService;
import ru.store.service.cart.impl.CartServiceImpl;

@Getter
public class CartGetInstance {
    private static volatile CartService instance;

    synchronized CartService getInstance(CartService instance) {
        if (instance == null) {
            instance = new CartServiceImpl();
        }
        return instance;
    }
}
