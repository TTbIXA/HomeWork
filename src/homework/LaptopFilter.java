package homework;

import java.util.*;
import java.util.stream.Collectors;

public class LaptopFilter {

    private Set<Laptop> laptops;

    public LaptopFilter(Set<Laptop> laptops) {
        this.laptops = laptops;
    }

    public void filterLaptops() {
        Scanner scanner = new Scanner(System.in);
        Map<String, Object> filterCriteria = new HashMap<>();

        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");

        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                System.out.print("Введите минимальный объем ОЗУ (в ГБ): ");
                int minRam = scanner.nextInt();
                filterCriteria.put("ram", minRam);
                break;
            case "2":
                System.out.print("Введите минимальный объем ЖД (в ГБ): ");
                int minHdd = scanner.nextInt();
                filterCriteria.put("hdd", minHdd);
                break;
            case "3":
                System.out.print("Введите операционную систему: ");
                String os = scanner.next();
                filterCriteria.put("os", os);
                break;
            case "4":
                System.out.print("Введите цвет: ");
                String color = scanner.next();
                filterCriteria.put("color", color);
                break;
            default:
                System.out.println("Неверный выбор!");
                return;
        }

        scanner.close();

        List<Laptop> filteredLaptops = laptops.stream()
                .filter(laptop -> matchCriteria(laptop, filterCriteria))
                .collect(Collectors.toList());

        System.out.println("Ноутбуки, соответствующие критериям:");
        filteredLaptops.forEach(System.out::println);
    }

    private boolean matchCriteria(Laptop laptop, Map<String, Object> criteria) {
        for (Map.Entry<String, Object> entry : criteria.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            switch (key) {
                case "ram":
                    if (laptop.getRam() < (int) value) return false;
                    break;
                case "hdd":
                    if (laptop.getHdd() < (int) value) return false;
                    break;
                case "os":
                    if (!laptop.getOs().equalsIgnoreCase((String) value)) return false;
                    break;
                case "color":
                    if (!laptop.getColor().equalsIgnoreCase((String) value)) return false;
                    break;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Set<Laptop> laptops = new HashSet<>();
        laptops.add(new Laptop(8, 500, "Windows", "Black"));
        laptops.add(new Laptop(16, 1000, "MacOS", "Silver"));
        laptops.add(new Laptop(32, 2000, "Windows", "Red"));
        laptops.add(new Laptop(128, 1000, "Windows", "Blue"));
        laptops.add(new Laptop(4, 250, "MacOs", "Pink"));


        LaptopFilter filter = new LaptopFilter(laptops);
        filter.filterLaptops();
    }
}
