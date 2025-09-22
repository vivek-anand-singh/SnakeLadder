public class Ladder extends Skipper {
    
    public Ladder(Coordinate bottom, Coordinate top) {
        super(bottom, top);
        if (bottom.toPosition(10) >= top.toPosition(10)) {
            throw new IllegalArgumentException("Ladder bottom must be at lower position than top");
        }
    }
    
    @Override
    public boolean canSkip(Coordinate position) {
        return position.equals(start);
    }
    
    public Coordinate getBottom() {
        return start;
    }
    
    public Coordinate getTop() {
        return end;
    }
}
