public interface GameRule {
    boolean canStart(Player player);
    boolean canEnd(Player player, int position, int boardSize);
    boolean shouldKill(Player player, int position);
}
