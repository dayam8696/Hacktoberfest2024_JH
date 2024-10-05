import java.util.ArrayList;
import java.util.Scanner;

public class cart {
    private static ArrayList<String> name = new ArrayList<>();
    private static ArrayList<String> price = new ArrayList<>();
    public static void add(String[][] list, int choice) {
        String nameArray =  list[choice][0];
        String priceArray = list[choice][1];
        name.add(nameArray);
        price.add(priceArray);
    }
    public static void display() {
        while (true) {
            double sum = 0;
            System.out.println();
            System.out.println("--------------------- User's Cart ---------------------");
            for (int i = 0; i < name.size(); i++) {
                char rs = '₹';
                System.out.printf(i + 1 + ". " + "%50s", name.get(i) + "     " + rs + Double.parseDouble(price.get(i)));
                System.out.println();
                sum += Double.parseDouble(price.get(i));
            }

            System.out.println("----------------------- Summary ----------------------");
            System.out.println("Total Items Added: " + name.size());
            System.out.println("Grand Total (incl. TAX): ₹" + sum);


            System.out.println("Enter 0 for going back");
            Scanner scanner = new Scanner(System.in);
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 0) {
                System.out.println("Going back...");
                break;

            } else {
                System.out.println("Absurd value entered, please try again");

            }
        }
        main.mainMenuLoader();
    }
}
