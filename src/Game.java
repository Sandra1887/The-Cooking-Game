import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game{
    ArrayList<Monster> monsters;
    ArrayList<Monster> bosses;
    Player player;
    Monster monster;

    Monster boss;
    Shop shop;
    boolean exit = false;
    public Game() {
        this.player = new Player("Player");
        this.monsters = new ArrayList<>();
        this.monsters.add(new AngryChef("Heston Blumenthal", player));
        this.monsters.add(new AngryChef("Jamie Oliver", player));
        this.monsters.add(new AngryChef("Gordan Ramsay", player));
        this.monsters.add(new AngryGuest("Old Lady", player));
        this.monsters.add(new AngryGuest("Gluten-intolerant woman", player));
        this.monsters.add(new AngryGuest("Stuck-up Rich Guy", player));
        this.bosses = new ArrayList<>();
        this.bosses.add(new Boss("Anthony Bourdain", player));
        this.bosses.add(new Boss("Joël Robuchon", player));
        this.bosses.add(new Boss("Massimo Bottura", player));
    }

    public void askForName() {
        player = new Player(enterName());
        shop = new Shop(player);
        while(player.isStillCooking()) {
            startGame();
        }
    }

    public void startGame() {
        while (!exit) {
            Helper.printMainMenu();
            switch (Helper.askForNumber(1, 4)) {
                case 1 -> startPlaying();
                case 2 -> shopping();
                case 3 -> printPlayer();
                case 4 -> {
                    exitGame();
                    exit = true;
                }
            }
        }
    }

    String enterName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name");
        String name = sc.nextLine();
        System.out.println("Welcome " + name + "! To \n");
        System.out.printf("""
                 ██▀███  ▓█████   ██████ ▄▄▄█████▓ ▄▄▄       █    ██  ██▀███   ▄▄▄       ███▄    █ ▄▄▄█████▓
                ▓██ ▒ ██▒▓█   ▀ ▒██    ▒ ▓  ██▒ ▓▒▒████▄     ██  ▓██▒▓██ ▒ ██▒▒████▄     ██ ▀█   █ ▓  ██▒ ▓▒
                ▓██ ░▄█ ▒▒███   ░ ▓██▄   ▒ ▓██░ ▒░▒██  ▀█▄  ▓██  ▒██░▓██ ░▄█ ▒▒██  ▀█▄  ▓██  ▀█ ██▒▒ ▓██░ ▒░
                ▒██▀▀█▄  ▒▓█  ▄   ▒   ██▒░ ▓██▓ ░ ░██▄▄▄▄██ ▓▓█  ░██░▒██▀▀█▄  ░██▄▄▄▄██ ▓██▒  ▐▌██▒░ ▓██▓ ░\s
                ░██▓ ▒██▒░▒████▒▒██████▒▒  ▒██▒ ░  ▓█   ▓██▒▒▒█████▓ ░██▓ ▒██▒ ▓█   ▓██▒▒██░   ▓██░  ▒██▒ ░\s
                ░ ▒▓ ░▒▓░░░ ▒░ ░▒ ▒▓▒ ▒ ░  ▒ ░░    ▒▒   ▓▒█░░▒▓▒ ▒ ▒ ░ ▒▓ ░▒▓░ ▒▒   ▓▒█░░ ▒░   ▒ ▒   ▒ ░░  \s
                  ░▒ ░ ▒░ ░ ░  ░░ ░▒  ░ ░    ░      ▒   ▒▒ ░░░▒░ ░ ░   ░▒ ░ ▒░  ▒   ▒▒ ░░ ░░   ░ ▒░    ░   \s
                  ░░   ░    ░   ░  ░  ░    ░        ░   ▒    ░░░ ░ ░   ░░   ░   ░   ▒      ░   ░ ░   ░     \s
                   ░        ░  ░      ░                 ░  ░   ░        ░           ░  ░         ░         \s
                                                                                                           \s""");
        System.out.println();
        System.out.printf("""
                 ███▄ ▄███▓ ▄▄▄      ▓█████▄     ██░ ██  ▒█████   █    ██   ██████ ▓█████\s
                ▓██▒▀█▀ ██▒▒████▄    ▒██▀ ██▌   ▓██░ ██▒▒██▒  ██▒ ██  ▓██▒▒██    ▒ ▓█   ▀\s
                ▓██    ▓██░▒██  ▀█▄  ░██   █▌   ▒██▀▀██░▒██░  ██▒▓██  ▒██░░ ▓██▄   ▒███  \s
                ▒██    ▒██ ░██▄▄▄▄██ ░▓█▄   ▌   ░▓█ ░██ ▒██   ██░▓▓█  ░██░  ▒   ██▒▒▓█  ▄\s
                ▒██▒   ░██▒ ▓█   ▓██▒░▒████▓    ░▓█▒░██▓░ ████▓▒░▒▒█████▓ ▒██████▒▒░▒████▒
                ░ ▒░   ░  ░ ▒▒   ▓▒█░ ▒▒▓  ▒     ▒ ░░▒░▒░ ▒░▒░▒░ ░▒▓▒ ▒ ▒ ▒ ▒▓▒ ▒ ░░░ ▒░ ░
                ░  ░      ░  ▒   ▒▒ ░ ░ ▒  ▒     ▒ ░▒░ ░  ░ ▒ ▒░ ░░▒░ ░ ░ ░ ░▒  ░ ░ ░ ░  ░
                ░      ░     ░   ▒    ░ ░  ░     ░  ░░ ░░ ░ ░ ▒   ░░░ ░ ░ ░  ░  ░     ░  \s
                       ░         ░  ░   ░        ░  ░  ░    ░ ░     ░           ░     ░  ░
                                      ░                                                  \s""");
        System.out.println();
        return name;
    }

    public void startPlaying() {
        double randNumb = Math.random();
        int sum = (int) ((Math.random()+1) * player.getLevel());
        if (randNumb < 0.1) {
            System.out.println("It's pay time baby, you got " + sum + " in tips");
            player.receiveTips(sum);
            Helper.pressEnter();
            newCookOff();
        } else {
            newCookOff();
        }
    }

    public void newCookOff() {
        Monster monster = randomMonster(monsters);
        System.out.println("You'll be bitchin' with " + monster.getName() + " " + monster.getHp() + "hp");
        Helper.pressEnter();
        while (player.isStillCooking()) {
            choosePlayerAttack(monster, player);

            if (!monster.isStillBitching()) {
                monsterIsDead(monster);
                break;
            }

            System.out.println(monster.getName() + " has " + monster.getHp() + "hp left\n");
            checkPlayerLevel();
            askForUsingDefence();
            chooseMonsterAttack(monster, player);

            if(!player.isStillCooking()) {
                gameOver();
            }

            System.out.println("Your current hp: " + player.getHp());
            Helper.pressEnter();
        }
    }

    private Monster randomMonster(ArrayList<Monster> list) {
        Random random = new Random();
        int index = random.nextInt(list.size());
        return list.get(index);
    }

    void choosePlayerAttack(Monster monster, Player player) {
        switch (player.attack()) {
            case 1 -> new FoodAttack().attack(monster, player);
            case 2 -> new SplashAttack().attack(monster, player);
            case 3 -> new SlippingAttack().attack(monster, player);
            case 4 -> new ChoppingAttack().attack(monster, player);
            case 5 -> new FryAttack().attack(monster, player);
        }
    }

    void checkPlayerLevel() {
        if (player.getXp() >= 10) {
            player.levelUp();
            if(player.getLevel() == 10) {
                bossFight();
            }
        }
    }

    void chooseMonsterAttack(Monster monster, Player player) {
        switch (monster.attack()) {
            case 1 -> new SpittingAttack().attack(monster, player);
            case 2 -> new ThrowingAttack().attack(monster, player);
            case 3 -> new TrippingAttack().attack(monster, player);
            case 4 -> new PouringAttack().attack(monster, player);
            case 5 -> new YellingAttack().attack(monster, player);
        }
    }

    void monsterIsDead(Monster monster) {
        int takeXp = monster.giveXp() * player.getLevel();
        System.out.println("You killed " + monster.getName() + " and got " + monster.getTips() + " in tips and " +
                takeXp + " in xp");
        player.receiveTips(monster.giveTips());
        player.increaseXp(takeXp);
        monster.resetMonsterStats(player);
        continuePlaying();
    }

    void askForUsingDefence() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Would you like to use or buy any defence? y/enter");
        String answer = sc.nextLine();
        if(answer.equalsIgnoreCase("y")) {
            System.out.println("""
                    1. Buy new defence
                    2. Use defence""");
            int choice = Helper.askForNumber(1, 2);
            switch(choice) {
                case 1 -> {
                    shop.printItemMenu();
                    int choice2 = Helper.askForNumber(1, 5);
                    shop.buyDefence(choice2);
                }
                case 2 -> chooseDefence();
                default ->
                        System.out.println("Invalid input");
            }
            if(player.getItemList().size() == 0) {
                System.out.println("You don't have any defence left\n");
            } else {
                chooseDefence();
            }
        }
    }

    void chooseDefence() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Item> currentList = player.getItemList();
        System.out.println("Which item would you like to use?");
        for(int i = 0; i<currentList.size(); i++) {
            Item item = currentList.get(i);
            System.out.println((i+1) + ". " + item.getName() + " defends " + item.getDefence() + "hp");
        }
        int choice = sc.nextInt();
        sc.nextLine();
        if(choice < 1 || choice > currentList.size()) {
            System.out.println("Invalid input");
        }
        Item item = currentList.get(choice-1);
        player.defend(item);
    }
    void continuePlaying() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to continue playing? y/n");
        if(sc.nextLine().equalsIgnoreCase("y")) {
            newCookOff();
        } else {
            startGame();
        }
    }

    void bossFight() {
        Monster boss = randomMonster(bosses);
        System.out.println("BOSS FIGHT!\nYou be fighting for your chef honor against " + boss.getName());
        Helper.pressEnter();
        while (player.isStillCooking()) {
            choosePlayerAttack(boss, player);

            if (!boss.isStillBitching()) {
                winBossFight();
                break;
            }

            System.out.println(boss.getName() + " has " + boss.getHp() + "hp left\n");
            askForUsingDefence();
            chooseMonsterAttack(boss, player);

            if(!player.isStillCooking()) {
                gameOver();
            }

            System.out.println("Your current hp: " + player.getHp());
            Helper.pressEnter();
        }
    }

    void winBossFight() {
        System.out.println("CONGRATULATIONS! You stood tall all through the game and can now call yourself \"The greatest Chef" +
                " of all times\"");
        playAgain();
    }

    void playAgain() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Do you want to play again? y/n");
        if(sc.nextLine().equalsIgnoreCase("y")) {
            player.resetAllStats();
            monster.resetMonsterStats(player);
            boss.resetMonsterStats(player);
            startGame();
        } else {
            System.out.println("Until next time, Boss!");
            System.exit(0);
        }
    }

    void gameOver() {
        Scanner sc = new Scanner(System.in);
        System.out.println("GAME OVER! Start from the beginning and try again? y/n");
        if(sc.nextLine().equalsIgnoreCase("y")){
            player.resetAllStats();
            newCookOff();
        } else {
            exitGame();
        }
    }

    void shopping() {
        shop.printWelcomeMessage();
        shop.displayShoppingChoice();
    }

    void printPlayer() {
        System.out.println(player);
    }

    void exitGame() {
        System.out.println("Well cooked! Go get some rest before the next unnecessary shit battle.");
        System.exit(0);
    }
}