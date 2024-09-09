import java.util.Scanner;

public class Shop extends Location{
    public Weapon weapon;
    public Weapon[] weapons;

    public Shop(Player player, String name) {
        super(player, name);
    }

    @Override
    boolean onLocation() {

        Weapon shortSword = new Weapon("Short Sword", 1,2,25);
        Weapon longSword = new Weapon("Long Sword", 2,3,35);
        Weapon greatSword = new Weapon("Great Sword", 3, 7,1);

        Armor leatherArmor = new Armor("Leather Armor", 1,1,15);
        Armor chainMail = new Armor("Chain Mail", 2, 3, 2);
        Armor fullPlate = new Armor("Full Plate", 3, 7, 40);

        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Shop!!");
        System.out.println("1. Weapon");
        System.out.println("2. Armor");
        System.out.println("3. Exit shop.");
        System.out.println("Enter your selection ");
        int selection = input.nextInt();
        switch (selection){
            case 1:
                buyWeapon(shortSword,longSword,greatSword);
                break;
            case 2:
                buyArmor(leatherArmor,chainMail,fullPlate);
                break;
            case 3:
                GameState.locationSelection();
            default:
                System.out.println("Wrong Entry");
                break;
        }
        onLocation();

        return false;
    }
    private void buyWeapon(Weapon weapon1,Weapon weapon2, Weapon weapon3){
        Scanner input = new Scanner(System.in);
        System.out.println("1. " + weapon1.getWeaponName() + "-- Weapon Damage => " + weapon1.getWeaponDamage() + " -- Weapon Money => " + weapon1.getWeaponMoney());
        System.out.println("2." + weapon2.getWeaponName() + "-- Weapon Damage => " + weapon2.getWeaponDamage() + " -- Weapon Money => " + weapon2.getWeaponMoney());
        System.out.println("3." + weapon3.getWeaponName() + "-- Weapon Damage => " + weapon3.getWeaponDamage() + " -- Weapon Money => " + weapon3.getWeaponMoney());
        System.out.println("4.Return Shop");
        System.out.println("Which one do you buy?");
        System.out.println("Enter your selection");
        int selection = input.nextInt();
        switch (selection){
            case 1:
                buy(weapon1);
                break;
            case 2:
                buy(weapon2);
                break;
            case 3:
                buy(weapon3);
                break;
            case 4:
                onLocation();
                break;
            default:
                System.out.println("Wrong Entry");
                break;

        }

    }

    private void buyArmor(Armor armor1, Armor armor2, Armor armor3){
        Scanner input = new Scanner(System.in);
        System.out.println("1. " + armor1.getArmorName() + " --- Armor defence => " + armor1.getArmorDefence() + " --- Armor money =>" + armor1.getArmorMoney());
        System.out.println("2. " + armor2.getArmorName() + " --- Armor defence => " + armor2.getArmorDefence() + " --- Armor money =>" + armor2.getArmorMoney());
        System.out.println("3. " + armor3.getArmorName() + " --- Armor defence => " + armor3.getArmorDefence() + " --- Armor money =>" + armor3.getArmorMoney());
        System.out.println("4.Return Shop");
        System.out.println("Which one do you buy?");
        System.out.println("Enter your selection");
        int selection = input.nextInt();
        switch (selection){
            case 1:
                buy(armor1);
                break;
            case 2:
                buy(armor2);
                break;
            case 3:
                buy(armor3);
                break;
            case 4:
                onLocation();
                break;
            default:{
                System.out.println("Wrong Entry");
            }
        }

    }
    private void buy (Armor armor){
        if (player.getInventory().getArmorName().equals(armor.getArmorName())){
            System.out.println("You already have that armor ");
        }else {
            if (player.getCharacter().getMoney()>armor.getArmorMoney()) {
                player.getInventory().setArmorName(armor.getArmorName());
                player.getInventory().setArmorDefence(armor.getArmorDefence());
                player.getCharacter().setMoney(player.getCharacter().getMoney()- armor.getArmorMoney());
                System.out.println("Congrats! You now have " + armor.getArmorName());
            }else {
                System.out.println("Gold is not enough.");
            }
        }
    }
    private void buy (Weapon weapon){
        if (player.getInventory().getWeaponName().equals(weapon.getWeaponName())){
            System.out.println("You already have that weapon.");
        }else {
            if (player.getCharacter().getMoney()>weapon.getWeaponMoney()) {
                player.getInventory().setWeaponName(weapon.getWeaponName());
                player.getCharacter().setDamage(player.getCharacter().getFirstDamage() + weapon.getWeaponDamage());
                player.getCharacter().setMoney(player.getCharacter().getMoney()- weapon.getWeaponMoney());
                System.out.println("Congrats! You now have " + weapon.getWeaponName());
            }else {
                System.out.println("Gold is not enough.");
            }
        }
    }
}
