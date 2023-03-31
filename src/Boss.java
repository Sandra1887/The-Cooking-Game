public class Boss extends Monster{
    public Boss(String name, Player player) {
        super(name, player);
        resetMonsterStats(player);
    }
    @Override
    public void resetMonsterStats(Player player) {
        setXp(50);
        setHp(100);
        setTips(10000000);
    }
}
