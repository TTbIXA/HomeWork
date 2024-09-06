package lesson;

import java.util.List;

public interface VendingMachine {

    Product getProduct(String name);

    void initsProduct(List<Product> productList);
}
