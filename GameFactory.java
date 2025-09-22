import java.util.*;

public class GameFactory {
    
    public static Game createGame(int boardSize, DifficultyLevel difficulty, WinningStrategy strategy) {
        Board board = new Board(boardSize);
        
        addSkippers(board, boardSize, difficulty);
        
        List<Player> players = Arrays.asList(
            new HumanPlayer("P1", "Human"),
            new Bot("B1", "Bot", difficulty)
        );
        
        GameRule gameRule = new StandardGameRule(strategy);
        
        return new Game(board, players, gameRule);
    }
    
    private static void addSkippers(Board board, int boardSize, DifficultyLevel difficulty) {
        Random random = new Random();
        
        for (int i = 0; i < difficulty.getLadderCount(); i++) {
            int startPos = random.nextInt(boardSize * boardSize / 2) + 1;
            int endPos = startPos + random.nextInt(boardSize * boardSize / 3) + 10;
            
            if (endPos < boardSize * boardSize) {
                board.addSkipper(new Ladder(
                    Coordinate.fromPosition(startPos, boardSize),
                    Coordinate.fromPosition(endPos, boardSize)
                ));
            }
        }
        
        for (int i = 0; i < difficulty.getSnakeCount(); i++) {
            int startPos = random.nextInt(boardSize * boardSize / 2) + boardSize * boardSize / 2;
            int endPos = startPos - random.nextInt(boardSize * boardSize / 3) - 10;
            
            if (endPos > 0) {
                board.addSkipper(new Snake(
                    Coordinate.fromPosition(startPos, boardSize),
                    Coordinate.fromPosition(endPos, boardSize)
                ));
            }
        }
    }
}
