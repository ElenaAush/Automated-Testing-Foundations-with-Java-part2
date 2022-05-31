package threads.mainTask;

public class Lot {
    private final String name;
    private int price;
    
    public Lot(String name, int price) {
        this.name = name;
        this.price = price;
    }
    
    public String getName() {
        return name;
    }
    
    public int getPrice() {
        return price;
    }
    
    public void setPrice(int price) {
        this.price = price;
    }
    
    @Override
    public String toString() {
        return name + ", " + price;
    }
}
