package lesson;

public class HotDrink extends Product {

    private String name;
    private double price;
    private int temperature;


    public HotDrink(String name, int price, int temperature){
        super(name, price);
        this.name = name;
        this.price = price;
        this.temperature = temperature;
    }


    @Override
    public String toString() {
        return "HotDrink{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", temperature=" + temperature +
                '}';
    }

    public int getTemperature(){
        return temperature;

    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }


}
