import java.lang.RuntimeException;
import java.util.ArrayList;

public class Player {
    
    String name;
    private int energyLevel;
    private int maxEnergy;
    private double balance;
    int x;
    int y;

    Inventory inventory;
    ArrayList<Bug> bugCase;
   
    public Player(String name){
        this.name = name.toUpperCase();
        this.energyLevel = 100;
        this.maxEnergy = 100;
        this.bugCase = new ArrayList<>();
        this.inventory = new Inventory();
        this.x = 0;
        this.y = 0;
    }

    public void checkInventory(){
        this.inventory.checkInventory(this);
    }

    public void checkBugs(){
        if(this.bugCase.isEmpty()){
            throw new RuntimeException("No bugs here...");
        } else {
            System.out.println("------------------------------------");
            System.out.println("BUGS");
            for(int bug = 0; bug < bugCase.size(); bug++){ 
                System.out.println("- " + bugCase.get(bug));
            }
            System.out.println("------------------------------------");
        }
    }

    public void eat(Snack s){
        if (this.getEnergyLevel() + s.getEnergyBonus() >= this.maxEnergy){
            throw new RuntimeException("You are full!");
        } else{
            System.out.println(this.name + " is eating " + s);
            this.energyLevel += s.getEnergyBonus();
            this.inventory.remove(s);
        }

    public void move(String direction){
        if (direction.toLowerCase().equals("north")){
            if(this.y - 1 < 0){
                throw new RuntimeException("This way leads to unavigatable woods. Don't go any further.");
            } else {
                this.y --;
            }
        } else if (direction.toLowerCase().equals("south")){
            if(this.y + 1 > 4){
                throw new RuntimeException("This way leads to unavigatable woods. Don't go any further.");
            } else {
                this.y ++;
            }
        } else if (direction.toLowerCase().equals("east")){
            if(this.x + 1 > 4){
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

