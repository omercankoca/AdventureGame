public class Character {
    private String characterClass;
    private int characterID;
    private int damage;
    private int health;
    private int money;
    private int firstHealth;
    private int firstDamage;
    Character(){}

    public Character(String characterClass, int characterID, int damage, int health, int money) {
        this.characterClass = characterClass;
        this.characterID = characterID;
        this.damage = damage;
        this.health = health;
        this.money = money;
        this.firstDamage = damage;
    }

    public int getFirstDamage() {
        return firstDamage;
    }

    public void setFirstDamage(int firstDamage) {
        this.firstDamage = firstDamage;
    }

    public int getFirstHealth() {
        return firstHealth;
    }

    public void setFirstHealth(int firstHealth) {
        this.firstHealth = firstHealth;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    public int getCharacterID() {
        return characterID;
    }

    public void setCharacterID(int characterID) {
        this.characterID = characterID;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
