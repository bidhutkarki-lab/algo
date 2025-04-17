package algo.missingRange;

import java.util.ArrayList;
import java.util.List;

/*
163. Leetcode missing ranges but with

Formatting Rules:

For 1 number → return "x"

For range → return "x->y"

Return result as a list of strings
*/
public class MissingRangesVariant {

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        int n = nums.length;
        List<String> result = new ArrayList<>();

        if (n == 0) {
            addRange(result, lower, upper);
            return result;
        }

        if (lower < nums[0]) {
            addRange(result, lower, nums[0] - 1);
        }

        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] > 1) {
                addRange(result, nums[i - 1] + 1, nums[i] - 1);
            }
        }

        if (upper > nums[n - 1]) {
            addRange(result, nums[n - 1] + 1, upper);
        }

        return result;
    }

    private void addRange(List<String> result, int start, int end) {
        if (start > end) return;
        if (start == end) {
            result.add(String.valueOf(start));
        } else if((end - start) == 1) {
            result.add(String.valueOf(start));
            result.add(String.valueOf(end));
        } else {
            result.add(String.valueOf(start) + "->" + String.valueOf(end));
        }
    }

    public static void main(String[] args) {
        MissingRangesVariant solver = new MissingRangesVariant();

        int[] nums1 = {5, 8, 9, 15, 16, 18, 20};
        int lower1 = 2;
        int upper1 = 87;
        System.out.println("Example 1 Output: " + solver.findMissingRanges(nums1, lower1, upper1));
        // Expected: ["2->4", "6", "7", "10->14", "17", "19", "21->87"]

        int[] nums2 = {0, 1, 3, 50, 75};
        int lower2 = 0;
        int upper2 = 99;
        System.out.println("Example 2 Output: " + solver.findMissingRanges(nums2, lower2, upper2));
        // Expected: ["2", "4->49", "51->74", "76->99"]
    }

}
