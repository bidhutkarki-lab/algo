package algo.randomPickIndex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/*
398. Random Pick Index variant

Time Complexity: O(n) - where n is the number of elements in the list.
Space Complexity: O(m) - where m is the number of indices of the maximum value.
 */
public class MaxIndexRandomPicker {

    public static int pickMaxIndex(List<Integer> nums) {
        int max = Collections.max(nums); // First pass: get max value


        List<Integer> maxIndices = new ArrayList<>();
        for(int i=0; i<nums.size(); i++) {
            if(nums.get(i) == max) {
                maxIndices.add(i); // Second pass: collect indices of max value
            }
        }
        Random rand = new Random();
        return maxIndices.get(rand.nextInt(maxIndices.size())); // Pick one randomly
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(5, 3, 9, 9, 2, 9);
        int index = pickMaxIndex(nums);
        System.out.println("Picked index: " + index + ", value = " + nums.get(index));
    }

}
