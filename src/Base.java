import java.util.Scanner;

public class Base extends Location{
    public Base(Player player, String name) {
        super(player, name);
    }

    @Override
    boolean onLocation() {
        Scanner input = new Scanner(System.in);
        System.out.println("You are in the base");
        System.out.println("1. renew your health");
        System.out.println("2. show stats");
        System.out.println("3. Exit base");
        int selection = input.nextInt();

        switch (selection){
            case 1:
                System.out.println("Your healt renewed " + player.getCharacter().getHealth() + " to " + player.getCharacter().getFirstHealth());
                player.getCharacter().setHealth(player.getCharacter().getFirstHealth());
                break;
            case 2:
                System.out.println("Player Name : " + player.getName());
                System.out.println("Player Class : " + player.getCharacter().getCharacterClass());
                System.out.println("Player Damage : " + player.getCharacter().getDamage());
                System.out.println("Player Health : " + player.getCharacter().getHealth());
                System.out.println("Player Armor Name : " + player.getInventory().getArmorName());
                System.out.println("Player Armor Defence : " + player.getInventory().getArmorDefence());
                System.out.println("Player Weapon Name : " + player.getInventory().getWeaponName());
                System.out.println("Player Gold : " + player.getCharacter().getMoney());
                break;
            case 3:
                GameState.locationSelection();
                break;
        }
        onLocation();
        return false;
    }
}
