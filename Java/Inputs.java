package basics;

import java.util.Scanner;

public class Inputs {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in) ;
        System.out.println("enter your rollno");
                int roll_no = input.nextInt();
        System.out.println("Your rollno is " + roll_no);
    }
}
