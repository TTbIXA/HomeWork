package lesson;

import java.util.ArrayList;
import java.util.List;

public class BottleWaterVendingMachine implements VendingMachine{
    private List<BottleWater> bottleOfWothers = new ArrayList<>();

    private final List<Product> productList;

    private  int money;

    public BottleWaterVendingMachine(List<Product> productList) {
        this.productList = productList;
    }


    @Override
    public Product getProduct(String name) {
        for (Product product : productList){
            if (product.getName().equals(name)){
                money += product.getPrice();
                return product;
            }
        }
        return null;
    }

    @Override
    public void initsProduct(List<Product> productList) {
        for (Product i : productList){
            bottleOfWothers.add((BottleWater) i);
        }

    }

    public BottleWater getProduct(String name, int volume){
        for (Product product: productList){
            if (product instanceof BottleWater){
                if (product.getName().equals(name) && ((BottleWater) product).getVolume() == volume){
                    return (BottleWater) product;
                }
            }
        }
        return null;
    }
}
