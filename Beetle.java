import java.util.Random;
public class Beetle extends Bug {

    int difficulty;

    public Beetle(int difficulty){
        super(difficulty);
        this.name = "beetle";
    }

    public String toString(){
        return this.name;
    }

// If you use the right tool, you can catch the bug. If not, 50/50 chance.
    public boolean wrangle(Tool tool){
        System.out.println("Wrangling " + this.name + " using " + tool + "...");
        if (tool.toString().equals("ordinary cup")){
            return true; 
        } else {
        Random random = new Random();
        int randInt = random.nextInt(difficulty);
        if (randInt <= difficulty/2){
            return true;
        } else {
            return false;
        }
        }
    }
    
}
