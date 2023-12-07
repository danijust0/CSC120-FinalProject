abstract class Bug{

    private int difficulty;
    String name;


    public Bug(int difficulty){
        this.difficulty = difficulty;
    }

    public int getDifficulty(){
        return this.difficulty;
    }

    abstract boolean wrangle(Tool tool);
}
