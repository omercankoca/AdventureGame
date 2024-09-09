public class Weapon {
    private String weaponName;
    private int weaponID;
    private int weaponDamage;
    private int weaponMoney;

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public int getWeaponID() {
        return weaponID;
    }

    public void setWeaponID(int weaponID) {
        this.weaponID = weaponID;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponDamage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
    }

    public int getWeaponMoney() {
        return weaponMoney;
    }

    public void setWeaponMoney(int weaponMoney) {
        this.weaponMoney = weaponMoney;
    }

    public Weapon(String weaponName, int weaponID, int weaponDamage, int weaponMoney) {
        this.weaponName = weaponName;
        this.weaponID = weaponID;
        this.weaponDamage = weaponDamage;
        this.weaponMoney = weaponMoney;
    }
}
