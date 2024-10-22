package entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShoppingCart
{
    private List<Product> items;

    public ShoppingCart()
    {
        this.items = new ArrayList<>();
    }

    public void addProduct(Product newProduct)
    {
        items.add(newProduct);
    }

    public void removeProduct (Product product)
    {
        items.remove(product);
    }

    public List<Product> getItems ()
    {
        return Collections.unmodifiableList(items);
    }

}
