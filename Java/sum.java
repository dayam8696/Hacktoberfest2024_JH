package basics;

import java.util.Scanner;

public class sum{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the first number");
        float num1 = input.nextFloat();
        System.out.println("Enter the second number");
        float num2 = input.nextFloat();
        float sum = num1+num2;
        System.out.println("Sum = " + sum);


    }
}
