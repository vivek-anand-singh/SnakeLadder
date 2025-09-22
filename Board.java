import java.util.*;

public class Board {
    private final int size;
    private final Map<Integer, Skipper> skippers;
    private final int winningPosition;
    
    public Board(int size) {
        this.size = size;
        this.skippers = new HashMap<>();
        this.winningPosition = size * size;
    }
    
    public void addSkipper(Skipper skipper) {
        int startPosition = skipper.getStartPosition(size);
        skippers.put(startPosition, skipper);
    }
    
    public int movePlayer(int currentPosition, int steps) {
        int newPosition = currentPosition + steps;
        
        if (newPosition > winningPosition) {
            return currentPosition;
        }
        
        if (skippers.containsKey(newPosition)) {
            Skipper skipper = skippers.get(newPosition);
            Coordinate currentCoord = Coordinate.fromPosition(newPosition, size);
            if (skipper.canSkip(currentCoord)) {
                return skipper.getEndPosition(size);
            }
        }
        
        return newPosition;
    }
    
    public boolean isWinningPosition(int position) {
        return position == winningPosition;
    }
    
    public int getSize() {
        return size;
    }
    
    public int getWinningPosition() {
        return winningPosition;
    }
    
    public Coordinate getCoordinate(int position) {
        return Coordinate.fromPosition(position, size);
    }
}
