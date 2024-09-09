import java.util.Random;

public class Obstacle {
    String obstacleName;
    int obstacleID;
    int obstacleDamage;
    int obstacleHealth;
    int obstacleMoney;
    int obstacleNumber;
    int obstacleFirstDamage;


    public Obstacle(String obstacleName, int obstacleID, int obstacleDamage, int obstacleHealth, int obstacleMoney) {
        this.obstacleName = obstacleName;
        this.obstacleID = obstacleID;
        this.obstacleDamage = obstacleDamage;
        this.obstacleHealth = obstacleHealth;
        this.obstacleMoney = obstacleMoney;
        this.obstacleFirstDamage = obstacleDamage;
    }
    public Obstacle(Obstacle obstacle){
        this.obstacleName = obstacle.obstacleName;
        this.obstacleDamage = obstacle.obstacleDamage;
        this.obstacleID = obstacle.obstacleID;
        this.obstacleHealth = obstacle.obstacleHealth;
        this.obstacleMoney = obstacle.obstacleMoney;
        this.obstacleFirstDamage = obstacle.obstacleDamage;
    }
    Random random = new Random();

    public String getObstacleName() {
        return obstacleName;
    }

    public void setObstacleName(String obstacleName) {
        this.obstacleName = obstacleName;
    }

    public int getObstacleID() {
        return obstacleID;
    }

    public void setObstacleID(int obstacleID) {
        this.obstacleID = obstacleID;
    }

    public int getObstacleDamage() {
        return obstacleDamage;
    }

    public void setObstacleDamage(int obstacleDamage) {
        this.obstacleDamage = obstacleDamage;
    }

    public int getObstacleHealth() {
        return obstacleHealth;
    }

    public void setObstacleHealth(int obstacleHealth) {
        this.obstacleHealth = obstacleHealth;
    }

    public int getObstacleMoney() {
        return obstacleMoney;
    }

    public void setObstacleMoney(int obstacleMoney) {

        this.obstacleMoney = obstacleMoney;
    }
    public void obstacleNumber(){

        int min = 1;
        int max = 3;
        obstacleNumber = random.nextInt(min,(max+1));

    }
}
