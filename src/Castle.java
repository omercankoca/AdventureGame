import java.util.Scanner;

public class Castle extends BattleLocation{
    public Castle(Player player, String name, Obstacle obstacle) {
        super(player, name, obstacle);
    }

    @Override
    public boolean onLocation() {
        finalCombat();
        return false;
    }

    public void finalCombat() {
        boolean isWin = false;
        Obstacle balrog = new Obstacle("BALROG", 5, 700, 2300, 1500);
        int playerHealth = player.getCharacter().getHealth();
        Scanner input = new Scanner(System.in);
        while (playerHealth > 0){
            System.out.println("Here is the BALROG coming toward to you!!");
            System.out.println("What do you want to do?");
            System.out.println("Press 'H' to hit --- Press 'R' to run");
            String choose = input.nextLine().toUpperCase();

            if (choose.equals("H")) {
                if (balrog.obstacleHealth > 0) {
                    hit(balrog, 1, false);

                    hit(balrog, 1, true);
                } else {
                    isWin =true;
                    break;
                }
                playerHealth = player.getCharacter().getHealth();
                System.out.println(player.getName() + " health " + player.getCharacter().getHealth());
            } else if (choose.equals("R")) {
                System.out.println("RUN YOU FOOL");
                isWin = false;
                break;
            }
        }
        if (!isWin) {
            System.out.println("!!!GAME OVER!!!");
        }else {
            System.out.println("THE END");
        }
    }
}

