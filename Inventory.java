import java.util.ArrayList;

public class Inventory {
    private ArrayList<Grabbable> inventory;
    private int maxCapacity = 5;

    public Inventory(){
        this.inventory =  new ArrayList<Grabbable>();
    }

    public void checkInventory(Player p){
        if(this.inventory.isEmpty()){
            System.out.println("There's nothing in here...");
        } else {
            System.out.println(p.name + "'s inventory...");
            for(Grabbable o : inventory){
                System.out.println(o);
            }
        }
    }
    
// COME BACK HERE WHEN NPC CLASS IS BUILT
    // public void check_inventory(String NPC){
    //         System.out.println(NPC+ "'s inventory...");
    //         for(Grabbable o : inventory){
    //             System.out.println(o);
    //         }
    //     }
    // }

    public void add(Grabbable o) {
        if (this.inventory.size() >= this.maxCapacity) {
            throw new RuntimeException("Your backpack is too full! Drop something first.");
        } else {
            this.inventory.add(o);
        }
    }

    public void remove(Grabbable o){
        if(this.inventory.contains(o)){
            this.inventory.remove(o);
        } else {
            throw new RuntimeException("this object is not in your inventory...");
        }

    }
}
