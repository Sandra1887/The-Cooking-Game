import java.util.Random;

public class AngryGuest extends Monster {
    public AngryGuest(String name, Player player) {
        super(name, player);
        resetMonsterStats(player);
    }

    @Override
    public int giveXp() {
        return new Random().nextInt(5)+1;
    }

    @Override
    public void resetMonsterStats(Player player) {
        setXp(5 * player.getLevel());
        setHp(10 * player.getLevel());
        setTips((new Random().nextInt(5) + 1) * (new Random().nextInt(5) + 1));
    }
}