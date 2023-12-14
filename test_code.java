class test_code {
    public static void main(String[] args) {
        Player Dani = new Player("dani");
        Dani.checkInventory();
        Dani.check_balance();
    
        Tool Cup = new Tool("Cup", 2.0,2);
        Dani.take(Cup);
        Dani.checkInventory();
    
        Snack Donut = new Snack("donut", 2.0, 2);
        Dani.take(Donut);
        Dani.checkInventory();
    
        Spider spider = new Spider(12);
        System.out.println(spider.wrangle(Cup));
    
        Location [][] map = new Location[5][5];

        for (int row = 0; row < 5; row++){
            for (int col = 0; col < 5; col++){
                map[row][col] = new Location();
            }
        }
    
        map[0][0].bugs.add(spider);
        map[0][0].getSurroundings();
        map[0][1].getSurroundings();
    
        Dani.move("west");
        Dani.getCoords();
     
    }
}