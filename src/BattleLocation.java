import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public abstract class BattleLocation extends Location {
    Obstacle obstacle;
    boolean isWin;
    Obstacle[] obstacles;
//    Screens screens;

    public BattleLocation(Player player, String name, Obstacle obstacle) {
        super(player, name);
        this.obstacle = obstacle;
    }

    @Override
    public boolean onLocation() {

        obstacle.obstacleNumber();
        obstacles = new Obstacle[obstacle.obstacleNumber];
        for (int i = 0; i < obstacle.obstacleNumber; i++) {
            obstacles[i] = new Obstacle(obstacle);
            GameState.obstacleMoneyRandomizer(obstacles[i]);
        }
        combat();


        if (isWin) {
            int resultGold = 0;
            for (Obstacle value : obstacles) {
                resultGold += value.obstacleMoney;
            }
            player.getCharacter().setMoney(player.getCharacter().getMoney() + (resultGold));
            System.out.println(" You win !! ");
            try {
                TimeUnit.MILLISECONDS.sleep(80);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(" You gained " + (resultGold) + " gold. Now you have " + player.getCharacter().getMoney() + " gold." );

        } else {
            System.out.println(" You lose !! ");
            try {
                TimeUnit.MILLISECONDS.sleep(80);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

        return isWin;
    }

    public void combat() {
        isWin = false;
        int obstacleNumber = obstacle.obstacleNumber;
        int tempObstacleNumber = obstacleNumber;
        int playerHealth = player.getCharacter().getHealth();
        Scanner input = new Scanner(System.in);
        int j = 0;
        System.out.println("You saw " + obstacleNumber + " " + obstacle.getObstacleName() + " coming towards you!!");

        while ((playerHealth > 0 && tempObstacleNumber > 0)) {

            System.out.println("What do you want to do?");
            System.out.println("Press 'H' to hit --- Press 'R' to run");
            String choose = input.nextLine();

            if (choose.equals("H")){
                if (obstacles[j].obstacleHealth > 0) {
                    for (int i = 0; i < tempObstacleNumber; i++) {
                        hit(obstacles[i], i , false);
                    }
                    hit(obstacles[j], j , true);
                } else {
                    j++;
                    for (int k = 0; k < tempObstacleNumber; k++) {
                        hit(obstacles[k], k , false);
                    }
                    hit(obstacles[j], j , true);

                }
                tempObstacleNumber = obstacles[j].getObstacleHealth() <= 0 ? tempObstacleNumber-1: tempObstacleNumber;
                playerHealth = player.getCharacter().getHealth();
                System.out.println(player.getName() + " health " + player.getCharacter().getHealth());
                isWin = tempObstacleNumber <= 0;
            } else if (choose.equals("R")) {
                System.out.println("You run to combat.");
                break;

            }

        }
    }



    protected void hit(Obstacle obstacle , int index, boolean isCharacterHit) {
        if (isCharacterHit){
            obstacle.setObstacleHealth(obstacle.getObstacleHealth() - player.getCharacter().getDamage());
            System.out.println(player.getName() + " deals " + player.getCharacter().getDamage() + " damage to the " + (index + 1) + ". " + obstacle.getObstacleName());
        }else{
            damageReducer(obstacle);
            player.getCharacter().setHealth(player.getCharacter().getHealth() - obstacle.getObstacleDamage());
            System.out.println(obstacle.getObstacleName() + " deals " + obstacle.getObstacleDamage() + " damage to the " + player.getName());
        }

    }

    public void damageReducer(Obstacle obstacle){
        obstacle.setObstacleDamage(obstacle.obstacleFirstDamage);
        if (player.getInventory().getArmorName().isEmpty()){
            return;
        }
        obstacle.setObstacleDamage(obstacle.obstacleDamage - player.getInventory().getArmorDefence());
        if (obstacle.getObstacleDamage() <= 0 ){
            obstacle.setObstacleDamage(0);
        }
        System.out.println(obstacle.getObstacleName() + " damage reduced to " + obstacle.getObstacleDamage() + " cause of your armor.");
    }


}

