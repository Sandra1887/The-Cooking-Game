import java.util.Random;

public class Monster {
    protected String name;
    protected int xp;
    protected int hp;
    protected int tips;
    Player player;

    public Monster(String name, Player player) {
        this.player = player;
        setName(name);
        setXp(10 * player.getLevel());
        setHp(5);
        setTips(new Random().nextInt(10)+1);
        resetMonsterStats(player);
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        if(name != null) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Invalid input");
        }
    }

    int getXp() {
        return xp;
    }

    void setXp(int xp) {
        if(xp >= 0) {
            this.xp = xp;
        } else {
            throw new IllegalArgumentException("Invalid input");
        }
    }

    int giveXp() {
        return new Random().nextInt(7)+1;
    }

    int getHp() {
        return hp;
    }

    void setHp(int hp) {
        if(hp > 0) {
            this.hp = hp;
        } else {
            throw new IllegalArgumentException("Invalid input");
        }
    }

    int getTips() {
        return this.tips;
    }

    void setTips(int tips) {
        if(tips >= 0) {
            this.tips = tips;
        } else {
            throw new IllegalArgumentException("Invalid input");
        }
    }

    int giveTips() {
        return this.tips;
    }

    public void decreaseHealth(int damage) {
        this.hp -= damage;
    }

    public int attack() {
        return new Random().nextInt(5) + 1;
    }

    public void resetMonsterStats(Player player) {
        setHp(10 * player.getLevel());
        setXp(10 * player.getLevel());
        setTips(new Random().nextInt(6) * player.getLevel());
    }

    public boolean isStillBitching() {
        return this.hp > 0;
    }

    @Override
    public String toString() {
        return getName() + " has " + getHp() + " hp";
    }
}