public class Coordinat        position--;
        int row = position / boardSize;{
    private final int x;
    private final int y;
    
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public int toPosition(int boardSize) {
        return y * boardSize + x + 1;
    }
    
    public static Coordinate fromPosition(int position, int boardSize) {
        position--; // Convert to 0-based
        int y = position / boardSize;
        int x = position % boardSize;
        return new Coordinate(x, y);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Coordinate that = (Coordinate) obj;
        return x == that.x && y == that.y;
    }
    
    @Override
    public int hashCode() {
        return x * 31 + y;
    }
    
    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
