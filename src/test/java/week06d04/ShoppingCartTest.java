package week06d04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {


    @Test
    void testCreate() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem("sör", 1000);
        shoppingCart.addItem("bor", 1);
        shoppingCart.addItem("sör", 1000);
        assertEquals(2000, shoppingCart.getShoppingList().get(0).getQuantity());
        assertEquals(1, shoppingCart.getShoppingList().get(1).getQuantity());
        assertEquals(2, shoppingCart.getShoppingList().size());

    }

}