public class Game {
public static void main(String[] args) {


//Main Game Loop
String action = " ";
while (!action.equals("go home")){
    action = sc.nextLine();
    switch(action){
        case "go north":
            player.move("north");
        case "go south":
                player.move("south");
        case "go east":
            player.move("east");
        case "go west":
                player.move("west");
}
}
}
}
