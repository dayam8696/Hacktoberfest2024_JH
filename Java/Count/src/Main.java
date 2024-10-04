import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.######");
        int[] arr = {-4, 3, -9, 0, 4, 1};
        float[] results = Count.plusMinus(arr);

        // Print the results with formatting
        System.out.println("Negative ratio: " + df.format(results[0]));
        System.out.println("Positive ratio: " + df.format(results[1]));
        System.out.println("Zero ratio: " + df.format(results[2]));

    }
}
class Count {
    public static float[] plusMinus(int[] arr){
        int counterMin = 0;
        int counterPlus = 0;
        int counter = 0;
        int n = arr.length;
        for(int i = 0; i< arr.length; i++){
            if (arr[i]<0) counterMin += 1;
            else if (arr[i]>0) counterPlus += 1;
            else counter += 1;
        }
        return new float[]{(float) counterMin/n, (float) counterPlus/n,(float)  counter/n};
    }
}

