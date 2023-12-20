public class Snack extends Grabbable {

    private int energy_bonus; 

    public Snack(String name, double price, int energy_bonus){
        super(name, price);
        this.energy_bonus = energy_bonus;
    }

    public int getEnergyBonus(){
        return energy_bonus;
    }

    public void examine(){
        System.out.println("This is a" + this.name);
    }
}
