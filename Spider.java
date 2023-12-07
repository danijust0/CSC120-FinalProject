import java.util.Random;
public class Spider extends Bug {

    int difficulty;

    public Spider(int difficulty, String name){
        super(difficulty, name);
    }

// If you use the right tool, you can catch the bug. If not, 50/50 chance.
    public boolean wrangle(String tool){
        System.out.println("Wrangling " + this.name + " using " + tool + "...");
        if (tool.equals("Cup")){
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
