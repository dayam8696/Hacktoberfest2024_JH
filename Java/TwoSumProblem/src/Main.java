import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3, 2, 4};
        int target = 7;
        int[] result = solution.twoSum(nums,target);
        if (result.length == 0)
            System.out.println("no Solution found");
        else
            System.out.println(Arrays.toString(result));
        }
    }

class Solution{
    public int[] twoSum(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<>();
        int[] results = new int[]{};
        for (int i = 0; i<nums.length; i++){
            int pair = target - nums[i];
            if (map.containsKey(pair)){
                results =  new int[]{map.get(pair),i};
            }
            map.put(nums[i], i);
        }
        return results;
    }
}