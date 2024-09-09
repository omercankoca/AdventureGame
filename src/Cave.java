public class Cave extends BattleLocation{
    Obstacle obstacle;
    Obstacle[] obstacles;
    public Cave(Player player, String name, Obstacle obstacle) {
        super(player, name, obstacle);

    }

    @Override
    public boolean onLocation() {

        super.onLocation();
        if (!isWin) {
            GameState.locationSelection();
            return false;
        }
        if (player.getInventory().isWater()){
            System.out.println("You already have unique item");
        }else{
            System.out.println("You earn the unique item.");
            player.getInventory().setWater(true);

        }
        GameState.locationSelection();
        return false;

    }
}
