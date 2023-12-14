import java.util.ArrayList;

public class Location {
    ArrayList<Bug> bugs;

    public Location(){
       this.bugs = new ArrayList<>();
    }

    public void getSurroundings(){
        if (this.bugs.isEmpty()){
            System.out.println("There's nothing interesting here...");
        } else {
        System.out.println("There's a rustling in the surrounding grass.");
        System.out.println("Squinting, you see...");
        for(int bug = 0; bug<this.bugs.size(); bug++){
            System.out.println(this.bugs.get(bug).name);
        }
        System.out.println("What do you want to do?");
        }
    }

// searches for bug in location, calls wrangle
    public void seekAndDestroy(Tool tool){
        if(this.bugs.get(0).wrangle(tool)){
            System.out.println(this.bugs.get(0).name + "wrangled");
        }
    }
}

