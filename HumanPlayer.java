import java.util.Random;

public class HumanPlayer extends Player {
    private Random dice;
    
    public HumanPlayer(String id, String name) {
        super(id, name);
        this.dice = new Random();
    }
    
    @Override
    public int rollDice() {
        return dice.nextInt(6) + 1;
    }
}
