public class Dungeon extends BattleLocation{
    Obstacle obstacle;
    Obstacle[] obstacles;
    public Dungeon(Player player, String name, Obstacle obstacle) {
        super(player, name, obstacle);
    }
    public boolean onLocation() {

        super.onLocation();
        if (!isWin) {
            GameState.locationSelection();
            return false;
        }
        if (player.getInventory().isFirewood()){
            System.out.println("You already have unique item");
        }else{
            System.out.println("You earn the unique item.");
            player.getInventory().setFirewood(true);

        }
        GameState.locationSelection();
        return false;

    }
}
