import java.util.Random;
import java.util.Scanner;

public class GameState {
    public static Base base;
    public static Cave cave;
    public static Forest forest;
    public static Dungeon dungeon;
    public static Shop shop;
    public static Castle castle;
    public static Player currentP;


    public static void onStart(Player currentPlayer, Obstacle caveObstacle, Obstacle forestObstacle, Obstacle dungeonObstacle) {
        currentP = new Player(currentPlayer);
        cave = new Cave(currentPlayer, "Cave", caveObstacle);
        forest = new Forest(currentPlayer, "Forest", forestObstacle);
        dungeon = new Dungeon(currentPlayer, "Dungeon", dungeonObstacle);
        shop = new Shop(currentPlayer, "Shop");
        base = new Base(currentPlayer, "Base");
        castle = new Castle(currentPlayer,"Castle",caveObstacle);
    }

    public static void locationSelection() {
        if (!(currentP.getInventory().isWater() && currentP.getInventory().isFood() && currentP.getInventory().isFirewood())) {
            if (currentP.getCharacter().getHealth() > 0) {
                Scanner input = new Scanner(System.in);
                System.out.println("Where do you want to go?");
                System.out.println("1. Base");
                System.out.println("2. Cave");
                System.out.println("3. Forest");
                System.out.println("4. Dungeon");
                System.out.println("5. Shop");
                int selection = input.nextInt();

                switch (selection) {
                    case 1:
                        base.onLocation();
                        break;
                    case 2:
                        cave.onLocation();
                        break;
                    case 3:
                        forest.onLocation();
                        break;
                    case 4:
                        dungeon.onLocation();
                        break;
                    case 5:
                        shop.onLocation();
                        break;
                }
            } else {
                System.out.println("Game Over");
            }
        }else {
            finalChapter();
        }

    }
    public static void finalChapter() {
        Scanner input = new Scanner(System.in);
        currentP.getCharacter().setHealth(10000);
        currentP.getCharacter().setDamage(1000);
        currentP.getInventory().setArmorDefence(500);
        System.out.println("You have 3 unique items from 3 different places. This makes you ELDEN LORD...");
        System.out.println("Now My Lord... You can fight with the BALROG");
        System.out.println("Enter your decision my lord.");
        System.out.println("Press 'E' to go Castle --- Press 'R' to run away");
        String selection = input.nextLine();

        switch (selection) {
            case "E":
                castle.onLocation();
                break;
            case "R":
                System.out.println("RUN YOU FOOL");
                break;
            default:
                System.out.println("Wrong Entry");
                break;
        }

    }





    public static void obstacleMoneyRandomizer(Obstacle obstacle) {
        Random random = new Random();
        int max = obstacle.getObstacleMoney();
        obstacle.setObstacleMoney(random.nextInt(max));
    }
}
