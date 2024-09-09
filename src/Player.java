public class Player {
    private String name;
    private Character character;
    private Inventory inventory;

    Player(Player player){
        this.name = player.getName();
        this.character = player.getCharacter();
        this.inventory = player.inventory;
    }

    Player (String name, Character character, Inventory inventory){
        this.name = name;
        this.character = character;
        this.inventory = inventory;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public void selectCharacter(String name, Character character){
        this.name = name;
        this.character = character;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
