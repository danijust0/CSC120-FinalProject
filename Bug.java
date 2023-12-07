abstract class Bug{

    private int difficulty;
    String name;


    public Bug(int difficulty, String name){
        this.difficulty = difficulty;
        this.name = name;
    }

    public int getDifficulty(){
        return this.difficulty;
    }


    abstract boolean wrangle();
}