import java.util.Scanner;

public class menuLoader {

    public static void stealDeal(){
        //String identifer = "deal"
        String[][] dealList = {{"Momo Mia Meal (Veg)", "299", "Enjoy a combo of 1 Veg Momo Mia! personal pizza with 1 Pepsi PET bottle."},
            {"Momo Mia Meal (Non Veg)","339","Enjoy a combo of 1 Non Veg Momo Mia! personal pizza with 1 Pepsi PET bottle."},
            {"2 Personal Pizzas Starting @", "249","Choose any 2 of your favorite personal pizza"},
            {"Flavour Fun - Box of 4", "399", "Savour 4 assorted Flavour Fun Pizzas with exciting sauces: Chatpata, Cheesy, Schezwan & Classic"}};
        listItemsPrice(dealList);

    }

    public static void pizza() {
        System.out.println("pizza");
    }

    public static void sides() {
        System.out.println("sides");
    }

    public static void dd() {
        System.out.println("dessert");
    }
    public static void listItemsPrice(String[][] list) {
        for (int i = 0; i < list.length; i++) {
            String name = list[i][0];
            int price = Integer.parseInt(list[i][1]);
            char rs = '₹';
            System.out.printf(i+1 + ". " + "%50s", name + "     " +rs+ price );
            System.out.println();
        }

        System.out.println("Please enter your choice to view description and configuration. 0 for going back");
        Scanner scanner = new Scanner(System.in);
        int choice = Integer.parseInt(scanner.nextLine());
        listItemsDescription(choice, list);
    }
    public static void listItemsDescription(int choice, String[][] list) {
        if (choice > list.length || choice <0) {
            System.out.println("Absurd value entered, please try again");
            listItemsPrice(list);
        }
        if (choice ==0){
            System.out.println("Going back...");
            main.mainMenuLoader();
        }
        String name = list[choice-1][0];
        double price = Double.parseDouble(list[choice-1][1]);
        String description = list[choice-1][2];

        System.out.println(name);
        System.out.println();
        System.out.println(description);
        System.out.println();
        System.out.println("₹" + price);

        System.out.println("Enter 1 for adding to cart, 0 for going back");
        Scanner scanner = new Scanner(System.in);
        int cartChoice = Integer.parseInt(scanner.nextLine());
        if (cartChoice == 1) {
            cart.add(list, choice);
            cart.display();
        }
        if (cartChoice == 0) {
            listItemsPrice(list);
        }
        else{
            listItemsDescription(choice, list);
        }
    }
}
