public class Ladybug extends Bug {

    int difficulty;

    public Ladybug(int difficulty){
        super(difficulty);
        this.name = "ladybug";
    }

    public String toString(){
        return this.name;
    }

// Easy to catch 100% chance
    public boolean wrangle(Tool tool){
        System.out.println("Wrangling " + this.name + " using " + tool + "...");
            return true; 
    }
    
}

    