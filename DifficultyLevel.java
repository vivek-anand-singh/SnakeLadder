public enum DifficultyLevel {
    EASY(2, 4),
    MEDIUM(4, 6),
    HARD(6, 8);
    
    private final int snakeCount;
    private final int ladderCount;
    
    DifficultyLevel(int snakeCount, int ladderCount) {
        this.snakeCount = snakeCount;
        this.ladderCount = ladderCount;
    }
    
    public int getSnakeCount() {
        return snakeCount;
    }
    
    public int getLadderCount() {
        return ladderCount;
    }
}
