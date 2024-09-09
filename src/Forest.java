public class Forest extends BattleLocation{
    Obstacle obstacle;
    Obstacle[] obstacles;
    public Forest(Player player, String name, Obstacle obstacle) {
        super(player, name, obstacle);
    }
    public boolean onLocation() {

        super.onLocation();
        if (!isWin) {
            GameState.locationSelection();
            return false;
        }
        if (player.getInventory().isFood()){
            System.out.println("You already have unique item");
        }else{
            System.out.println("You earn the unique item.");
            player.getInventory().setFood(true);

        }
        GameState.locationSelection();
        return false;

    }
}
