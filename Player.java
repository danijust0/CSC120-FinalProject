

public class Player {
    
    String name;
    int energyLevel;
    int skillLevel;
    double balance;
    Inventory inventory;
   
    public Player(String name){
        this.name = name.toUpperCase();
        this.energyLevel = 100;
        this.skillLevel = 1;
        this.balance = 0.0;
        this.inventory = new Inventory();
    }

    public void check_balance(){
        if(this.balance > 0.0){
            System.out.println(this.name + "s wallet has " + this.balance + " buttons");
        } else {
            System.out.println("A single crumb tumbles out of your wallet... you find not a single button inside.");
        }
    }
}

