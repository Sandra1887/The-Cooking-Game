import java.util.*;

public class Shop {

    private final ArrayList<Item> items;
    Player player;

    public Shop(Player player) {
        this.items = new ArrayList<>();
        this.player = player;
        items.add(new Item("Coffee", 5, 15));
        items.add(new Item("Beer", 10, 20));
        items.add(new Item("Wet towel", 15, 30));
        items.add(new Item("Apron of Steel", 20, 40));
        items.add(new Item("Gas burner", 25, 50));
    }


    int printShopMenu() {
        System.out.println("1. Shop for defence");
        System.out.println("2. Display your items");
        System.out.println("3. Exit shop");
        return Helper.askForNumber(1, 3);
    }

    void displayShoppingChoice() {
        int choice = printShopMenu();
        boolean exit = false;
        while (!exit) {
            switch (choice) {
                case 1 -> {
                    printItemMenu();
                    buyDefence(Helper.askForNumber(1, 5));
                    exit = true;
                }
                case 2 -> {
                    printDefenceItems();
                    exit = true;
                }
                case 3 -> exit = true;
            }
        }
    }

    void printWelcomeMessage() {
        System.out.println("Welcome to the shop! What would you like to do today?");
    }
    void printItemMenu() {
        System.out.printf("""
                Your current tips are %s 
                1. Coffee               5 tips
                2. Beer                 10 tips
                3. Wet towel            15 tips
                4. Apron of Steel       20 tips
                5. Gas burner           25 tips\n""", player.getTips());
    }
    void buyDefence(int choice) {
        Item itemChosen = items.get(choice - 1);
        if (player.getTips() >= itemChosen.getPrice()) {
            player.addItemToList(itemChosen);
            player.decreaseTips(itemChosen.getPrice());
            System.out.println(itemChosen.getName() + " is added to your inventory.\n");
        } else {
            System.out.println("You do not have enough tips. Work harder!!");
            Helper.pressEnter();
        }
    }

    void printDefenceItems() {
        System.out.println("Your items:");
        for (int i = 0; i < player.getItemList().size(); i++) {
            System.out.println((i + 1) + ". " + player.getItemList().get(i));
        }
        System.out.println();
    }
}