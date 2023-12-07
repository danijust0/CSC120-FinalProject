import java.util.ArrayList;

public class Inventory {
    ArrayList<Grabbable> inventory;
    int maxCapacity = 5;

    public Inventory(){
        this.inventory =  new ArrayList<Grabbable>();
    }

    public void check_inventory(Player p){
        if(this.inventory.isEmpty()){
            System.out.println("There's nothing in here...");
        } else {
            System.out.println(p.name + "'s inventory...");
            for(Grabbable o : inventory){
                System.out.println(o);
            }
        }
    }

    public void add(Grabbable o) {
        if (this.inventory.size() >= this.maxCapacity) {
            throw new RuntimeException("Your backpack is too full! Drop something first.");
        } else {
            this.inventory.add(o);
        }
    }

    public void drop_item(Grabbable o){
        if(this.inventory.contains(o)){
            this.inventory.remove(o);
        } else {
            throw new RuntimeException("this object is not in your inventory...");
        }

    }
}
