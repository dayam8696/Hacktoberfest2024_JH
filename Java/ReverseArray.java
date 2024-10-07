public class RevArr {
    public static void main(String[] args) {
        // Creating an array
        int [] arr = new int [] {11, 12, 13, 14, 15};
        
        // Printing the array
        System.out.println("Original Array:");
        
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        
        System.out.println();
        System.out.println();
        
        System.out.println("Reversed Array:");
        
        // Reversing and printing the array
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
    }
}