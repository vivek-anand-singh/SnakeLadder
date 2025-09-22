public class SnakeLadderMain {
    public static void main(String[] args) {
        Game game = GameFactory.createGame(10, DifficultyLevel.MEDIUM, WinningStrategy.EXACT_MATCH);
        
        System.out.println("=== Snake and Ladder Game Started ===");
        
        int maxTurns = 100;
        int turns = 0;
        
        while (!game.isGameEnded() && turns < maxTurns) {
            game.displayBoard();
            game.playTurn();
            turns++;
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        
        if (game.isGameEnded()) {
            System.out.println("\n=== Game Ended ===");
            System.out.println("Winner: " + game.getWinner().getName());
        } else {
            System.out.println("\n=== Game ended due to max turns reached ===");
        }
    }
}
