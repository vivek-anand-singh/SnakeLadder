public abstract class Skipper {
    protected Coordinate start;
    protected Coordinate end;
    
    public Skipper(Coordinate start, Coordinate end) {
        this.start = start;
        this.end = end;
    }
    
    public abstract boolean canSkip(Coordinate position);
    
    public Coordinate getDestination() {
        return end;
    }
    
    public Coordinate getStart() {
        return start;
    }
    
    public int getStartPosition(int boardSize) {
        return start.toPosition(boardSize);
    }
    
    public int getEndPosition(int boardSize) {
        return end.toPosition(boardSize);
    }
}
