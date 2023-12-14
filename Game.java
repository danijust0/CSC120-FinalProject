import java.util.Scanner;
import java.util.Random;

public class Game {

public static void main(String[] args) {

// Initiate Scanner     
Scanner sc = new Scanner(System.in);


// Title
System.out.println("------------------------------------");
System.out.println("BUG HUNT");
System.out.println("------------------------------------");

// Make Player
System.out.println("Hello bug hunter, what is your name?");
String name = sc.nextLine();
Player player = new Player(name);
System.out.println(player.name + ", huh? Interesting name. Fitting for an adventurous bug hunter such as yourself.");

System.out.println("------------------------------------");
System.out.println(" BEGINNER TOOLS");
System.out.println("------------------------------------");

Tool ordinaryCup = new Tool("ordinary cup", 10, 5);
Tool ordinaryNet = new Tool("ordinary net", 15, 5);
System.out.println(ordinaryCup.name);
System.out.println(ordinaryNet.name);
System.out.println("------------------------------------");
System.out.println("Pick your first bug hunting tool. This is an important choice. Some tools make it easier to catch certain bugs.");
String tool = sc.nextLine().toLowerCase();

switch(tool){
    case "ordinary cup":
        player.inventory.add(ordinaryCup);
        System.out.println("Added " + ordinaryCup.name + " to "+ player.name + "'s inventory.");
        break;
    case "ordinary net":
        player.inventory.add(ordinaryNet);
        System.out.println("Added " + ordinaryNet.name + " to " + player.name + "'s inventory");
        break;
    default:
        System.out.println("I don't understand " + tool + ", so I'll choose for you.");
        player.inventory.add(ordinaryCup);
        System.out.println("Added " + ordinaryCup.name + " to " + player.name + "'s inventory");
        break;
}

System.out.println("You're all ready to go. Happy bug hunting! Type a command to begin your journey..");

// Make Map
Location [][] map = new Location[5][5];

Random random = new Random();
for (int row = 0; row < 5; row++){
    for (int col = 0; col < 5; col++){
        map[row][col] = new Location();
        int nBugs = random.nextInt(2);
        for (int n = 0; n < nBugs ; n++){
            int randInt2 = random.nextInt(3);
            switch (randInt2){
                case 0:
                    map[row][col].bugs.add(new Spider(20));
                    break;
                case 1:
                    map[row][col].bugs.add(new Ladybug(2));
                    break;
                case 2:
                    map[row][col].bugs.add(new Beetle(15));
                    break;
                case 3:
                    map[row][col].bugs.add(new Butterfly(18));
                    break;
                }
        System.out.println(map[row][col].bugs);
            }
        }
      }

//Main Game Loop
String action = " ";
while (!action.equals("go home")){
    action = sc.nextLine();
    switch(action){

        case "move north":
        case "go north":
            try {
            player.move("north");
            } catch (Exception e){
                System.out.println("This way leads to unnavigatable woods. Let's go somewhere else....");
            }
            // FOR DEBUGGING 
            // System.out.println(action + " successful go north" );
            break;

        case "move south":   
        case "go south":
            try {
                player.move("south");
                } catch (Exception e){
                    System.out.println("This way leads to unnavigatable woods. Let's go somewhere else....");
                }
            // FOR DEBUGGING 
            // System.out.println(action + " successful go south");
            break;

        case "move east":
        case "go east":
            try {
                player.move("east");
                } catch (Exception e){
                    System.out.println("This way leads to unnavigatable woods. Let's go somewhere else....");
                }
            // FOR DEBUGGING 
            // System.out.println(action + " successful go east");
            break;

        case "move west":
        case "go west":
            try {
                player.move("west");
                } catch (Exception e){
                    System.out.println("This way leads to unnavigatable woods. Let's go somewhere else....");
                 }
            // FOR DEBUGGING 
            // System.out.println(action + " successful go west");
            break;
        
        case "look around":
            System.out.println(map[player.x][player.y].bugs);
            map[player.x][player.y].getSurroundings();
            // FOR DEBUGGING 
            // System.out.println(action + " successful look around");
            break;
        
        case "check inventory":
        case "open inventory":
        case "inventory":
                 player.checkInventory();
                 break;
        
        case "catch bug":
        case "wrangle bug":
                 try {
                    map[player.x][player.y].seekAndDestroy(ordinaryCup);
                    System.out.println("Wrangled");
                } catch (Exception e) {
                    System.out.println("Unsuccessful Wrangle");
                }
                //  if (map[player.x][player.y].bugs.isEmpty()){
                //     System.out.println("There are no bugs to wrangle...");
                //  } else{
                //     System.out.println("Which bug?");

                // }
                break;
                
           
        default: 
                System.out.println("I don't understand " + action);
}
}
}
}
