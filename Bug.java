import java.util.Random;

public class Bug{

    int difficulty;
    boolean can_fly;
    boolean can_swim;
    int energy;

    public Bug(int difficulty, boolean can_fly, boolean can_swim){
        this.difficulty = difficulty;
        this.can_fly = can_fly;
        this.can_swim = can_swim;
    }

    public boolean wrangle(){
    Random random = new Random();
    int number = random.nextInt(10);
    }


}
