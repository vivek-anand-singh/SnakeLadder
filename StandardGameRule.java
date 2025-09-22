public class StandardGameRule implements GameRule {
    private WinningStrategy winningStrategy;
    
    public StandardGameRule(WinningStrategy winningStrategy) {
        this.winningStrategy = winningStrategy;
    }
    
    @Override
    public boolean canStart(Player player) {
        return true;
    }
    
    @Override
    public boolean canEnd(Player player, int position, int boardSize) {
        int winningPosition = boardSize * boardSize;
        
        switch (winningStrategy) {
            case EXACT_MATCH:
                return position == winningPosition;
            case OVERFLOW_WIN:
                return position >= winningPosition;
            default:
                return position == winningPosition;
        }
    }
    
    @Override
    public boolean shouldKill(Player player, int position) {
        return false;
    }
}
