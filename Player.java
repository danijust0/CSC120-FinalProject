
public class Player {
    
    String name;
    private int energyLevel;
    private int maxEnergy;
    private double balance;

    Inventory inventory;
   
    public Player(String name){
        this.name = name.toUpperCase();
        this.energyLevel = 100;
        this.maxEnergy = 100;
        this.balance = 0.0;
        this.inventory = new Inventory();
    }

    public int getEnergyLevel(){
        return this.energyLevel;
    }


    public void checkInventory(){
        this.inventory.checkInventory(this);
    }

    public void take(Grabbable o) {
        this.inventory.add(o);
    }

    public void drop(Grabbable o){
        this.inventory.remove(o);
    }


    public void eat(Snack s){
        if (this.getEnergyLevel() + s.getEnergyBonus() >= this.maxEnergy){
            throw new RuntimeException("You are full!");
        } else{
            System.out.println(this.name + " is eating " + s);
            this.energyLevel += s.getEnergyBonus();
            this.inventory.remove(s);
        }
    }

    public void check_balance(){
        if(this.balance > 0.0){
            System.out.println(this.name + "s wallet has " + this.balance + " coins");
        } else {
            System.out.println("A single speck of dust tumbles out of your wallet... you find not a single coin inside.");
        }
    }
}

