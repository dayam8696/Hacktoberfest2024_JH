import java.util.Scanner;

public class main {
    public static final String[] optionList = {"Steal Deals", "Pizzas", "Sides", "Desserts and Drinks"};

    public static void main(String[] args) {
        String welcome = "************ Welcome to Pizza Jhopri! ************";
        System.out.println(welcome);
        System.out.println("");

        String menuWelcome = "********** What would you like to have! **********";
        System.out.println(menuWelcome);
        System.out.println("");

        mainMenuLoader();

    }

    public static void mainMenuLoader() {
        Scanner scanner = new Scanner(System.in);
        int choice =0;
        while (true) {
            int i = 0;
            for (String option : optionList) {
                i++;
                System.out.println(i + ". " + option);
            }

            System.out.println("Please enter the your choice, 0 to view cart");
            choice = Integer.parseInt(scanner.nextLine());

            if (choice <= 4) {
                break;
            }
            System.out.println("Absurd value entered, please try again");
        }

        menuParser.optionList(choice);

    }
}