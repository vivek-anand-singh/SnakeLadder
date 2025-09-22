public class Snake extends Skipper {
    
    public Snake(Coordinate head, Coordinate tail) {
        super(head, tail);
        if (head.toPosition(10) <= tail.toPosition(10)) {
            throw new IllegalArgumentException("Snake head must be at higher position than tail");
        }
    }
    
    @Override
    public boolean canSkip(Coordinate position) {
        return position.equals(start);
    }
    
    public Coordinate getHead() {
        return start;
    }
    
    public Coordinate getTail() {
        return end;
    }
}
