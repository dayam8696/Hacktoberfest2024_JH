import java.lang.reflect.Array;

public class ReverseArrayGeneric {
    
    // Generic method to reverse the array
    public static <T> void reverseArray(T[] array) {
        int left = 0;                   // Starting index
        int right = array.length - 1;   // Ending index
        
        while (left < right) {
            // Swap the elements at left and right indices
            T temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            
            // Move towards the middle
            left++;
            right--;
        }
    }

    // Method to print the array
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example with an Integer array
        Integer[] intArray = {1, 2, 3, 4, 5};
        System.out.println("Original Integer Array:");
        printArray(intArray);
        reverseArray(intArray);
        System.out.println("Reversed Integer Array:");
        printArray(intArray);
        
        // Example with a String array
        String[] strArray = {"Hello", "World", "Java", "Generics"};
        System.out.println("\nOriginal String Array:");
        printArray(strArray);
        reverseArray(strArray);
        System.out.println("Reversed String Array:");
        printArray(strArray);
        
        // Example with a Double array
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5};
        System.out.println("\nOriginal Double Array:");
        printArray(doubleArray);
        reverseArray(doubleArray);
        System.out.println("Reversed Double Array:");
        printArray(doubleArray);
    }
}
