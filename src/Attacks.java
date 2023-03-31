import java.util.Random;

interface Attacks {
    void attack(Monster monster, Player player);
}

class FoodAttack implements Attacks {
    public void attack (Monster monster, Player player) {
        int damage = new Random().nextInt(5) + 1;;
        int xp = monster.giveXp();
        System.out.println("You threw food on " + monster.getName() + " and made " + damage + " damage. \n-->You received " +
                xp + " in XP!");
        monster.decreaseHealth(damage);
        player.increaseXp(xp);
    }
}

class SplashAttack implements Attacks {
    public void attack(Monster monster, Player player) {
        int xp = monster.giveXp();
        int damage = new Random().nextInt(3) + 1;
        System.out.println("You splashed water on " + monster.getName() + " and made " + damage + " damage. \n-->You received " +
                xp + " in XP!");
        monster.decreaseHealth(damage);
        player.increaseXp(xp);
    }
}

class SlippingAttack implements Attacks {
    public void attack(Monster monster, Player player) {
        int xp = monster.giveXp();
        int damage = new Random().nextInt(7) + 1;
        System.out.println("You threw a banana at " + monster.getName() + "'s feet and made " + damage + " damage. \n-->You received " +
                monster.giveXp() + " in XP!");
        monster.decreaseHealth(damage);
        player.increaseXp(xp);
    }
}

class ChoppingAttack implements Attacks {
    public void attack(Monster monster, Player player) {
        int xp = monster.giveXp();
        int damage = new Random().nextInt(9) + 1;
        System.out.println("You chopped of one of " + monster.getName() + "'s limbs and made " + damage + " damage. \n-->You received " +
                xp + " in XP!");
        monster.decreaseHealth(damage);
        player.increaseXp(xp);
    }
}

class FryAttack implements Attacks {
    public void attack(Monster monster, Player player) {
        int xp = monster.giveXp();
        int damage = new Random().nextInt(8) + 1;
        System.out.println("You pushed " + monster.getName() + " into the fryer and made " + damage + " damage. \n-->You received " +
                xp + " in XP!");
        monster.decreaseHealth(damage);
        player.increaseXp(xp);
    }
}

class SpittingAttack implements Attacks { //från monster
    public void attack(Monster monster, Player player) {
        int damage = new Random().nextInt(3) + 1;
        System.out.println(monster.getName() + " spat in your face. The humiliation made " + damage
                + " in damage");
        player.decreaseHp(damage);
    }
}

class ThrowingAttack implements Attacks { //från monster
    public void attack(Monster monster, Player player) {
        int damage = new Random().nextInt(8) + 1;
        System.out.println(monster.getName() + " threw the plate in your head. The concussion made " + damage + " damage");
        player.decreaseHp(damage);
    }
}

class PouringAttack implements Attacks { //från monster
    public void attack(Monster monster, Player player) {
        int damage = new Random().nextInt(5) + 1;
        System.out.println(monster.getName() + " poured their drink over you and made " + damage + " damage");
        player.decreaseHp(damage);
    }
}

class TrippingAttack implements Attacks { //från monster
    public void attack(Monster monster, Player player) {
        int damage = new Random().nextInt(9) + 1;
        System.out.println(monster.getName() + " made you trip and the food flew all over the kitchen. It made " + damage + " damage");
        player.decreaseHp(damage);
    }
}

class YellingAttack implements Attacks {
    public void attack(Monster monster, Player player) {
        int damage = new Random().nextInt(6)+1;
        System.out.println(monster.getName() + " yelled their guts out and you got hit by a kidney. It made " + damage + " damage");
        player.decreaseHp(damage);
    }
}