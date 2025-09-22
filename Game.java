import java.util.*;

public class Game {
    private Board board;
    private List<Player> players;
    private GameRule gameRule;
    private int currentPlayerIndex;
    private boolean gameEnded;
    private Player winner;
    
    public Game(Board board, List<Player> players, GameRule gameRule) {
        this.board = board;
        this.players = new ArrayList<>(players);
        this.gameRule = gameRule;
        this.currentPlayerIndex = 0;
        this.gameEnded = false;
        this.winner = null;
    }
    
    public void playTurn() {
        if (gameEnded) {
            System.out.println("Game has already ended!");
            return;
        }
        
        Player currentPlayer = players.get(currentPlayerIndex);
        
        if (!gameRule.canStart(currentPlayer)) {
            nextPlayer();
            return;
        }
        
        int diceRoll = currentPlayer.rollDice();
        System.out.println(currentPlayer.getName() + " rolled " + diceRoll);
        
        int oldPosition = currentPlayer.getCurrentPosition();
        int newPosition = board.movePlayer(oldPosition, diceRoll);
        
        currentPlayer.setCurrentPosition(newPosition);
        
        System.out.println(currentPlayer.getName() + " moved from " + oldPosition + " to " + newPosition);
        
        if (gameRule.shouldKill(currentPlayer, newPosition)) {
            currentPlayer.setCurrentPosition(0);
            System.out.println(currentPlayer.getName() + " was killed and sent back to start!");
        }
        
        if (gameRule.canEnd(currentPlayer, newPosition, board.getSize())) {
            gameEnded = true;
            winner = currentPlayer;
            System.out.println(currentPlayer.getName() + " wins the game!");
            return;
        }
        
        nextPlayer();
    }
    
    private void nextPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }
    
    public boolean isGameEnded() {
        return gameEnded;
    }
    
    public Player getWinner() {
        return winner;
    }
    
    public Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }
    
    public void displayBoard() {
        System.out.println("\n=== Current Positions ===");
        for (Player player : players) {
            Coordinate coord = board.getCoordinate(player.getCurrentPosition());
            System.out.println(player.getName() + ": Position " + player.getCurrentPosition() + " " + coord);
        }
    }
}
