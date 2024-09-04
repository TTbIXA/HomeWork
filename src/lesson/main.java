package lesson;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args){

        List<Product> hotDrink = new ArrayList<>();
        hotDrink.add(new HotDrink("Americano", 500,70));
        hotDrink.add(new HotDrink("Mulled wine", 500,71));
        hotDrink.add(new HotDrink("Sea buckthorn tea", 500,72));
        System.out.println(hotDrink);

        HotDrinksVendingMachine hotDr = new HotDrinksVendingMachine();
        hotDr.initsProduct(hotDrink);
        System.out.println(hotDr.getProduct("Sea buckthorn tea"));
    }

}
