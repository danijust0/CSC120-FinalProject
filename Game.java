public class Game {
public static void main(String[] args) {
    Player Dani = new Player("dani");
    Dani.checkInventory();
    Dani.check_balance();

    Tool Cup = new Tool("cup", 2.0,2);
    Dani.take(Cup);
    Dani.checkInventory();

    Snack Donut = new Snack("donut", 2.0, 2);
    Dani.take(Donut);
    Dani.checkInventory();

    Spider spider = new Spider(12, "Spider");
    System.out.println(spider.wrangle("Cup"));

    Location [][] map = new Location[5][5];
    System.out.println(map);
}   
    
}
