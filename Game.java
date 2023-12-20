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
System.out.println("PICK YOUR STARTER TOOL");
System.out.println("------------------------------------");
System.out.println(Cup.name);
System.out.println(Net.name);
System.out.println("------------------------------------");
System.out.println("Pick your first bug hunting tool. This is an important choice. Some tools make it easier to catch certain bugs.");
String tool = sc.nextLine().toLowerCase();

switch(tool){
    case "cup":
        player.inventory.add(Cup);
        System.out.println("Added " + Cup.name + " to "+ player.name + "'s inventory.");
        break;
    case "net":
        player.inventory.add(Net);
        System.out.println("Added " + Net.name + " to " + player.name + "'s inventory");
        break;
    default:
        System.out.println("I don't understand " + tool + ", so I'll choose for you.");
        player.inventory.add(Cup);
        System.out.println("Added " + Cup.name + " to " + player.name + "'s inventory");
        break;
}

System.out.println("You're all ready to go. Happy bug hunting! Type a command to begin your journey, type HELP for controls...");

/**
 * Make 5x5 Map
 */
Location [][] map = new Location[5][5];

for (int row = 0; row < 5; row++){
    for (int col = 0; col < 5; col++){
        map[row][col] = new Location();
        map[row][col].generateItems();
        }
      }

/**
 * Main Game Loop
 */
String action = " ";
while (!action.equals("go home")){
    action = sc.nextLine().toLowerCase();
    switch(action){

        case "move north":
        case "go north":
            try {
            player.move("north");
            } catch (Exception e){
                System.out.println("This way leads to unnavigatable woods. Let's go somewhere else....");
            }
            break;

        case "move south":   
        case "go south":
            try {
                player.move("south");
                } catch (Exception e){
                    System.out.println("This way leads to unnavigatable woods. Let's go somewhere else....");
                }
            break;

        case "move east":
        case "go east":
            try {
                player.move("east");
                } catch (Exception e){
                    System.out.println("This way leads to unnavigatable woods. Let's go somewhere else....");
                }
            break;

        case "move west":
        case "go west":
            try {
                player.move("west");
                } catch (Exception e){
                    System.out.println("This way leads to unnavigatable woods. Let's go somewhere else....");
                 }
            break;
        
        case "look around":
            map[player.x][player.y].getSurroundings();
            break;
        
        case "check inventory":
        case "open inventory":
        case "inventory":
                    player.checkInventory();
                break;
        
        case "catch":
        case "wrangle":
                System.out.println("Using what?");
                String chosenTool = sc.nextLine();

                if (chosenTool.equals("cup")){
                    if (player.inventory.has(Cup)){
                        try {
                            map[player.x][player.y].seekAndDestroy(player, Cup);
                        } catch (Exception e) {
                            System.out.println("Bug Not Found");
                            } 
                    } else {
                        System.out.println("You don't have that tool.");
                    }
                } else if (chosenTool.equals("net")){
                    if (player.inventory.has(Net)){
                    try {
                        map[player.x][player.y].seekAndDestroy(player, Net);
                    } catch (Exception e) {
                        System.out.println("You Failed...");
                    }
                } else {
                    System.out.println("You don't have that tool.");
                }
                }
                break;

        case "take item":
        case "take":
                System.out.println("Take what? Use number to indicate.");
                System.out.println("------------------------------------");
                System.out.println("THINGS");
                for (int thing=0; thing < map[player.x][player.y].things.size(); thing++){
                    System.out.println(map[player.x][player.y].things.get(thing).name);
                }
                System.out.println("------------------------------------");
                try{
                    int chosenItem = sc.nextInt();
                    map[player.x][player.y].take(player, chosenItem-1);
                } catch (Exception e) {
                    System.out.println("No such item exists here...");
                }
            break;

        case "drop item":
        case "drop":
                player.checkInventory();
                System.out.println("Drop which item? Indicate using number...");
                try{
                    int chosenItem2 = sc.nextInt();
                    map[player.x][player.y].drop(player, chosenItem2-1);
                } catch (Exception e){
                System.out.println("This item cannot be dropped");
                }
                break;


        default: 
                System.out.println("I don't understand " + action);
}
}
}
}
