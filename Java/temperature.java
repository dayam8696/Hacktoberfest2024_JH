package basics;

import java.util.Scanner;

public class temperature {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the Temp in Celcius");
        float tempC = in.nextFloat();
        float tempF = (tempC * 9/5) + 32;
        System.out.println("Temp in F is "+ tempF);
    }
}
