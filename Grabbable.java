abstract class Grabbable {
    String name;
    double price;

    public Grabbable(String name, double price){
        this.name = name;
        this.price = price;
    }

// Contract
    abstract void examine();
}
