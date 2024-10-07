import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("Enter the size of the array: ");
        int size = Integer.parseInt(reader.readLine());
        int[] array = new int[size];
        
        System.out.println("Enter " + size + " elements (separated by spaces):");
        String[] input = reader.readLine().split(" ");
        
        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(input[i]);
        }
        
        System.out.println("Original array: " + Arrays.toString(array));
        reverseArray(array);
        System.out.println("Reversed array: " + Arrays.toString(array));
    }

    // Method to reverse the array
    public static void reverseArray(int[] arr) {
        for (int left = 0, right = arr.length - 1; left < right; left++, right--) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }
    }
}
