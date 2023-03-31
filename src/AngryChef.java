import java.util.Random;

public class AngryChef extends Monster{
    public AngryChef(String name, Player player) {
        super(name, player);
        resetMonsterStats(player);
    }
    @Override
    public int giveXp() {
        return new Random().nextInt(8)+2;
    }
    @Override
    public void resetMonsterStats(Player player) {
        setHp(10 * player.getLevel());
        setXp(10 * player.getLevel());
        setTips(new Random().nextInt(8) * player.getLevel());
    }
}