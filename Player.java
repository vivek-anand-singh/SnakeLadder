public abstract class Player {
    protected String id;
    protected String name;
    protected int currentPosition;
    
    public Player(String id, String name) {
        this.id = id;
        this.name = name;
        this.currentPosition = 0;
    }
    
    public abstract int rollDice();
    
    public void move(int steps) {
        this.currentPosition += steps;
    }
    
    public Coordinate getCoordinate(int boardSize) {
        return Coordinate.fromPosition(currentPosition, boardSize);
    }
    
    public int getCurrentPosition() {
        return currentPosition;
    }
    
    public void setCurrentPosition(int position) {
        this.currentPosition = position;
    }
    
    public String getName() {
        return name;
    }
    
    public String getId() {
        return id;
    }
}
