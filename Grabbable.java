import org.w3c.dom.NameList;

abstract class Grabbable {
    String name;
    double price;

    public Grabbable(String name, double price){
        this.name = name;
        this.price = price;
    }

    public String toString() {
        return this.getClass().getCanonicalName() + " at (" + this.x + "," + this.y + ")";
    }

// Contract
    abstract void take();
    abstract void examine();
}
