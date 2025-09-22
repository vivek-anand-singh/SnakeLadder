import java.util.Random;

public class Bot extends Player {
    private Random dice;
    private DifficultyLevel difficulty;
    
    public Bot(String id, String name, DifficultyLevel difficulty) {
        super(id, name);
        this.dice = new Random();
        this.difficulty = difficulty;
    }
    
    @Override
    public int rollDice() {
        return dice.nextInt(6) + 1;
    }
    
    public DifficultyLevel getDifficulty() {
        return difficulty;
    }
}
