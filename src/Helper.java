import java.util.Scanner;

public class Helper {

    public static void printMainMenu() {
        System.out.println("1. Hey goood looking, time to start cooking?");
        System.out.println("2. ..or maybe shopping?");
        System.out.println("3. Want to see your cooking skills?");
        System.out.println("4. Exhausted? Good job! Lets get some rest for today");
    }

    public static int askForNumber(int min, int max) {
        int choice = 0;
        if (min > choice || choice < max) {
            System.out.println("Enter a number between " + min + " and " + max);
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
        }
        return choice;
    }

    static void pressEnter() {
        System.out.println("\u235F\t Press enter \t\u235F");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }
}
