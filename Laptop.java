import java.util.Objects;

public class Laptop {
    private String brandLaptop;
    private String model;
    private int rom;
    private int ram;
    private String os;
    private String color;

    public Laptop (String brandLaptop, String model, int rom, int ram, String os, String color){
        this.brandLaptop = brandLaptop;
        this.model = model;
        this.rom = rom;
        this.ram = ram;
        this.os = os;
        this.color = color;
    }

    public String getBrandLaptop(){
        return brandLaptop;
    }

    public String getModel(){
        return model;
    }

    public String getColor(){
        return color;
    }

    public String getOs(){
        return os;
    }

    public int getRom(){
        return rom;
    }

    public int getRam(){
        return ram;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Brand Laptop: ");
        s.append(brandLaptop);
        s.append("\n");
        s.append("Model: ");
        s.append(model);
        s.append("\n");
        s.append("ROM: ");
        s.append(rom);
        s.append("\n");
        s.append("RAM: ");
        s.append(ram);
        s.append("\n");
        s.append("Operating system: ");
        s.append(os);
        s.append("\n");
        s.append("Color: ");
        s.append(color);
        s.append("\n");

        return s.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }

        if (obj == null || getClass() != obj.getClass()){
            return false;
        }

        Laptop laptop = (Laptop) obj;

        return brandLaptop.equals(laptop.brandLaptop) && model.equals(laptop.model)
        && rom == laptop.rom && ram == laptop.ram && color.equals(laptop.color) && os.equals(laptop.os);
    }

    @Override
    public int hashCode() {
        
        return Objects.hash(brandLaptop, model, rom, ram, os, color);
    }


    
}