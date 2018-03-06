package programcreek.arrays;

import java.util.*;

/**
 * Created by deepakkole on 1/31/18.
 */
public class TwoSums {

    public int[] twoSum(int[] arr, int target) {
            if(arr == null || arr.length <= 0){
                System.out.println("Empty or invalid array length");
                return null;
            }
            int i =0;
            int j = arr.length-1;

            while(i < j){
                int sum = arr[i] + arr[j];
                if(sum > target){
                    j--;
                } else if(sum<target){
                    i++;
                }else{
                    int[] results = {i, j};
                    return results;
                }
            }
            return null;
    }

    public int[] notSorted(int[] arr, int target){
        if(arr == null || arr.length <= 0){
            System.out.println("Empty or invalid array length");
            return null;
        }
        int i=0;

        Map<Integer, Integer> map = new HashMap<>();

        while(i < arr.length){
            int val2 = target - arr[i];
           if(map.containsKey(val2)){
               return new int[]{i, map.get(val2)};
           }else{
               map.put(i, val2);
           }
        }
        return new int[0];
    }
    public static void main(String[] args) {
        TwoSums sums = new TwoSums();
        int[] arr = {2, 7, 11, 15};

        int[] arr1 =sums.twoSum(arr, 9);
        System.out.println();
    }
}
