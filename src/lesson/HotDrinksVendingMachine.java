package lesson;

import java.util.ArrayList;
import java.util.List;

public class HotDrinksVendingMachine implements VendingMachine{

    private List<HotDrink> hotDrink = new ArrayList<>();

    @Override
    public Product getProduct(String name) {
        for (HotDrink i : hotDrink){
            if(i.getName().equals(name)){
                 return i;
            }
        }
        return null;
    }

    @Override
    public void initsProduct(List<Product> productList) {
        for (Product i  : productList){
            hotDrink.add((HotDrink)i);
        }

    }

    public Product getProducts(String name, int temperature){
        for (HotDrink i : hotDrink){
            if(i.getName().equals(name) && temperature == i.getTemperature()){
                return i;
            }
        }
        return null;
    }
}
