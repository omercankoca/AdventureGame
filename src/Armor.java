public class Armor {
    private String armorName;
    private int ArmorID;
    private int armorDefence;
    private int armorMoney;

    public Armor(String armorName, int armorID, int armorDefence, int armorMoney) {
        this.armorName = armorName;
        ArmorID = armorID;
        this.armorDefence = armorDefence;
        this.armorMoney = armorMoney;
    }

    public String getArmorName() {
        return armorName;
    }

    public void setArmorName(String armorName) {
        this.armorName = armorName;
    }

    public int getArmorID() {
        return ArmorID;
    }

    public void setArmorID(int armorID) {
        ArmorID = armorID;
    }

    public int getArmorDefence() {
        return armorDefence;
    }

    public void setArmorDefence(int armorDefence) {
        this.armorDefence = armorDefence;
    }

    public int getArmorMoney() {
        return armorMoney;
    }

    public void setArmorMoney(int armorMoney) {
        this.armorMoney = armorMoney;
    }
}
