import java.lang.RuntimeException;

public class Player {
    
    String name;
    private int energyLevel;
    private int maxEnergy;
    private double balance;
    int x;
    int y;

    Inventory inventory;
   
    public Player(String name){
        this.name = name.toUpperCase();
        this.energyLevel = 100;
        this.maxEnergy = 100;
        this.balance = 0.0;
        this.inventory = new Inventory();
        this.x = 0;
        this.y = 0;
    }

    public int getEnergyLevel(){
        return this.energyLevel;
    }
    public void getCoords(){
        System.out.println(this.x + "," + this.y);
    }

    public void checkInventory(){
        this.inventory.checkInventory(this);
    }

    public void check_balance(){
        if(this.balance > 0.0){
            System.out.println(this.name + "s wallet has " + this.balance + " coins");
        } else {
            System.out.println("A single speck of dust tumbles out of your wallet... you find not a single coin inside.");
        }
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

    public void move(String direction){
        if (direction.toLowerCase().equals("north")){
            if(this.y - 1 < 0){
                throw new RuntimeException("This way leads to unavigatable woods. Don't go any further.");
            } else {
                this.y --;
            }
        } else if (direction.toLowerCase().equals("south")){
            if(this.y + 1 > 5){
                throw new RuntimeException("This way leads to unavigatable woods. Don't go any further.");
            } else {
                this.y ++;
            }
        } else if (direction.toLowerCase().equals("east")){
            if(this.x + 1 > 5){
                throw new RuntimeException("This way leads to unavigatable woods. Don't go any further.");
            } else {
                this.x ++;
            }            
        } else if (direction.toLowerCase().equals("west")){
            if(this.x - 1 < 0){
                throw new RuntimeException("This way leads to unavigatable woods. Don't go any further.");
            } else {
                this.x --;
            } 
        } else {
            throw new RuntimeException("Invalid direction");
        }
    }
}

