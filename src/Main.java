import java.util.Scanner;
import java.util.concurrent.TimeUnit;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Character barbarian = new Character("Paladin", 1, 5, 21, 15);
        Character ranger = new Character("Ranger", 2, 7, 18, 20);
        Character paladin = new Character("Barbarian", 3, 8, 24, 5);


        System.out.println("Hello adventurer...");

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Welcome to SiliconHold... Here, an adventure awaits you. \n" +
                "If you manage to collect the unique items you need, \nthey will transform you into a "  +
                "powerful adventurer. \nYou must do everything in your power venture into \n harsh and perilous places," +
                "face off against various monsters, \nand conquer them all to claim the rare items. In the end, you will \n" +
                "come face to face with the greatest entity of SiliconHold, \nand you must defeat it. This is your destiny don't stand in its way.");


        System.out.print("Enter your username : ");
        String playerName = input.nextLine();
        System.out.println("Select your character");
        System.out.println("1.Paladin - damage:5 - health:21 - money:15");
        System.out.println("2.Ranger - damage:7 - health:18 - money:20");
        System.out.println("3.Barbarian - damage:8 - health:24 - money:5");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.print("Enter your selected character number : ");
        int selection = input.nextInt();

        Character tempCharacter = new Character();
        switch (selection) {
            case 1:
                tempCharacter = barbarian;
                break;
            case 2:
                tempCharacter = ranger;
                break;
            case 3:
                tempCharacter = paladin;
                break;
            default:
                System.out.println("Wrong entry.");
                break;
        }


        tempCharacter.setFirstHealth(tempCharacter.getHealth());
        Inventory inventory = new Inventory();
        Player currentPlayer = new Player(playerName, tempCharacter, inventory);



        Obstacle goblin = new Obstacle("Goblin", 1, 3, 10, 4);
        Obstacle imp = new Obstacle("Imp", 2, 4, 14,7);
        Obstacle skeleton = new Obstacle("Skeleton", 3, 7,20,12);


        GameState.onStart(currentPlayer,goblin, imp, skeleton);
        GameState.locationSelection();



    }

}
