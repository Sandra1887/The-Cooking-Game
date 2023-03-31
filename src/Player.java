import java.util.ArrayList;
import java.util.Random;

public class Player {
    private String name;
    private int level;
    private int xp;
    private int hp;
    private int tips;
    private int lives;
    private ArrayList<Item> itemList;

    public Player(String name) {
        setName(name);
        setLevel(1);
        setHp(10 * getLevel());
        setXp(0);
        setTips(0);
        setLives(5);
        itemList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name != null) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Invalid input");
        }
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        if(level > 0) {
            this.level = level;
        } else {
            throw new IllegalArgumentException("Invalid input");
        }
    }

    void levelUp() {
        level++;
        System.out.println("\n\u00BB\u00BB You leveled up! \u00AB\u00AB \nCurrent level: " + getLevel());
    }

    public void levelChange(int newXp) {
        this.xp = newXp;
        System.out.println("Current XP: " + getXp());
        System.out.println();
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        if(hp > 0) {
            this.hp = hp;
        } else {
            throw new IllegalArgumentException("Invalid input");
        }
    }

    public void increaseHp(int health) {
        this.hp += health;
    }

    public void decreaseHp(int damage) {
        this.hp -= damage;
        if (this.hp <= 0) {
            decreaseLives();
            System.out.println("You lost one life. You have --> " + getLives() + " <-- lives left");
        }
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        if (xp >= 0) {
            this.xp = xp;
        } else {
            throw new IllegalArgumentException("Invalid input");
        }
    }

    public void increaseXp(int xpValue) {
        this.xp += xpValue;
        int currentXpToLevel = 10 * getLevel();
        if(this.xp > currentXpToLevel) {
            levelUp();
            int newXP = this.xp - currentXpToLevel;
            levelChange(newXP);
        }
    }

    public int getTips() {
        return tips;
    }

    public void setTips(int tips) {
        if(tips >= 0) {
            this.tips = tips;
        } else {
            throw new IllegalArgumentException("Invalid input");
        }
    }

    public void receiveTips(int amount) {
        this.tips += amount;
    }

    public void decreaseTips(int amount) {
        this.tips -= amount;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        if(lives > 0) {
            this.lives = lives;
        } else {
            throw new IllegalArgumentException("Invalid input");
        }
    }

    public void decreaseLives() {
        if (this.hp <= 0) {
            this.lives--;
            resetLifeStats();
        } if (lives == 1) {
            System.out.println("You're running out of lives.. this is your last chance");
        }
    }

    public void resetLifeStats() {
        setHp(10 * getLevel());
        setXp(0);
    }

    public ArrayList<Item> getItemList() {
        return itemList;
    }

    public void addItemToList(Item item) {
        itemList.add(item);
    }

    public int attack() {
        Random random = new Random();
        return random.nextInt(5) + 1;
    }

    /**
     * <p>Defend method takes in the bought defence item
     * and chooses the defence that the item provides</p>
     */
    void defend(Item item) {
        if(itemList.contains(item)) {
            int hp = 0;
            if(item.getName().equalsIgnoreCase("Coffee")) {
                hp = new CoffeeDefence().defend();
            } else if (item.getName().equalsIgnoreCase("Beer")) {
                hp = new BeerDefence().defend();
            } else if (item.getName().equalsIgnoreCase("Wet towel")) {
                hp = new WetTowelDefence().defend();
            } else if (item.getName().equalsIgnoreCase("Apron of Steel")) {
                hp = new SteelApronDefence().defend();
            } else if (item.getName().equalsIgnoreCase("Gas burner")) {
                hp = new GasBurnerDefence().defend();
            } else {
                System.out.println("Invalid input");
            }
            itemList.remove(item);
            increaseHp(hp);
        }
    }

    public void resetAllStats() {
        setLevel(1);
        setHp(10);
        setXp(0);
        setTips(0);
        setLives(5);
    }

    public boolean isStillCooking() {
        return this.lives > 0;
    }

    public String toString() {
        return "Name: " + getName() + "\nLevel: " + getLevel() + "\nLives: " + getLives() + "\nHp: " +
                getHp() + "\nXp: " + getXp() + "\nTips: " + getTips() + "\nGoodie bag: " + getItemList() + "\n";
    }
}
