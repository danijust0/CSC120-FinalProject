public class Tool extends Grabbable{

    int bonus;

    public Tool(String name, double price, int bonus){
        super(name, price);
        bonus = this.bonus;
    }

    public void examine(){
        System.out.println("This is a" + this.name);
    }
}