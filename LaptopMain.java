import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class LaptopMain {

    public static void main(String[] args) {
        Laptop laptop1 = new Laptop("Xiaomi", "RedmiBook", 512, 16, "Windows", "Grey");
        Laptop laptop2 = new Laptop("Xiaomi", "Book Pro", 512, 8, "Linux", "White");
        Laptop laptop3 = new Laptop("Apple", "Macbook", 1024, 32, "MacOS", "Silver");
        Laptop laptop4 = new Laptop("Samsung", "GalaxyBook", 256, 8, "Windows", "Black");
        Laptop laptop5 = new Laptop("Microsoft", "Surface", 512, 16, "Windows", "Pink");
        Laptop laptop6 = new Laptop("Lenovo", "VivoBook", 256, 8, "Windows", "Gold");

        Set<Laptop> laptops = new HashSet<>();

        laptops.add(laptop1);
        laptops.add(laptop2);
        laptops.add(laptop3);
        laptops.add(laptop4);
        laptops.add(laptop5);
        laptops.add(laptop6);

        Map<Integer, String> filterLaptops = new HashMap<>();
        filterLaptops.put(1, "brand");
        filterLaptops.put(2, "rom");
        filterLaptops.put(3, "ram");
        filterLaptops.put(4, "os");
        filterLaptops.put(5, "color");

        Scanner s = new Scanner(System.in);

        while (true) {
            try {

                System.out.println("Enter the number corresponding to the criteroin: ");
                System.out.println("1 - brand");
                System.out.println("2 - ROM");
                System.out.println("3 - RAM");
                System.out.println("4 - Operating System");
                System.out.println("5 - Color");
                System.out.println("Input 'q' for exit");

                String input = s.nextLine();

                if (input.equals("q")) {
                    System.out.println("Goodbye");
                    break;
                }

                int numCriteroin = Integer.parseInt(input);

                if (filterLaptops.containsKey(numCriteroin)) {
                    String parametrFilter = filterLaptops.get(numCriteroin);
                    Set<String> valuesParametr = new HashSet<String>(getFieldValueLaptop(laptops, parametrFilter));
                    System.out.println("Select one the values and input him: " + valuesParametr);
                    String value = s.nextLine();
                    Set<Laptop> resultLaptops = new HashSet<>(getSetFilterLaptop(laptops, parametrFilter, value));
                    for (Laptop laptop : resultLaptops) {
                        System.out.println(laptop);
                        System.out.println();                        
                    }
                    break;                   

                } else {
                    System.out.println("Invalid selection parametr entered. You can try again.");
                }

            } catch (Exception e) {
                System.out.println("Exception: " + e.getMessage());
            }

        }

        s.close();

    }

    public static Set<Laptop> getSetFilterLaptop(Set<Laptop> laptops, String parametr, String value) {
        Set<Laptop> filtersSetLaptop = new HashSet<>(laptops);
        switch(parametr) {
            case "brand":
                for (Laptop laptop : laptops) {
                    String info = laptop.getBrandLaptop();
                    if(!value.equals(info)){
                        filtersSetLaptop.remove(laptop);
                    }                    
                }
                break;
            case "ram":
                for (Laptop laptop : laptops) {
                    int info = laptop.getRam();
                    int ramValue = Integer.parseInt(value);
                    if(info < ramValue){
                        filtersSetLaptop.remove(laptop);
                    }                     
                }
                break;
            case "rom":
                for (Laptop laptop : laptops) {
                    int info = laptop.getRom();
                    int romValue = Integer.parseInt(value);
                    if(info < romValue){
                        filtersSetLaptop.remove(laptop);
                    }                    
                }
                break;
            case "os":
                for (Laptop laptop : laptops) {
                    String info = laptop.getOs();
                    if(!value.equals(info)){
                        filtersSetLaptop.remove(laptop);
                    }                    
                }
                break;
            case "color":
                for (Laptop laptop : laptops) {
                    String info = laptop.getColor();
                    if(!value.equals(info)){
                        filtersSetLaptop.remove(laptop);
                    }                     
                }
                break;

        }
        

        return filtersSetLaptop;
    }

    public static Set<String> getFieldValueLaptop(Set<Laptop> laptops, String parametr){
        Set<String> fieldValueLaptop = new HashSet<>();
        switch(parametr) {
            case "brand":
                for (Laptop laptop : laptops) {
                    String info = laptop.getBrandLaptop();
                    fieldValueLaptop.add(info);                    
                }
                break;
            case "ram":
                for (Laptop laptop : laptops) {
                    String info = String.valueOf(laptop.getRam());
                    fieldValueLaptop.add(info);                    
                }
                break;
            case "rom":
                for (Laptop laptop : laptops) {
                    String info = String.valueOf(laptop.getRom());
                    fieldValueLaptop.add(info);                    
                }
                break;
            case "os":
                for (Laptop laptop : laptops) {
                    String info = laptop.getOs();
                    fieldValueLaptop.add(info);                    
                }
                break;
            case "color":
                for (Laptop laptop : laptops) {
                    String info = laptop.getColor();
                    fieldValueLaptop.add(info);                    
                }
                break;

        }
        return fieldValueLaptop;

    }
}