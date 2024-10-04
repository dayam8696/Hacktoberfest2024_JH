package basics;

import java.util.Scanner;

public class TypeCasting {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // type conversion
        float num = input.nextInt();
      //  int num1 = input.nextFloat(); not possible

        // type casting

        int num2 = (int) (67.56f);
        System.out.println(num2);

        // automatic type promotion in expression
//        int a = 257;
//        byte b = (byte)(a); // 257 % 256 = 1
//        System.out.println(b);
//
//        byte c = 40 ;
//        byte d = 50;
//        byte e = 100;
//        int f = c*d/e;
//        System.out.println(f);

        // one question that will be clear enough
        byte b = 42;
        char c = 'a';
        short s = 1024;
        int i = 50000;
        float f = 5.67f;
        double d = 0.1234;
        double result = (f*d) + (i/c) - (d*s);
        // FLOAT + INT -DOUBLE = DOUBLE (largest among all)
        System.out.println((f * b) + " + " + (i / c) + " - " + (d * s));
        System.out.println("result = " + result);





    }
}
