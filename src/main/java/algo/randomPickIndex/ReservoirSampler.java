package algo.randomPickIndex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/*
398. Random Pick Index variant

You’re dealing with large data (or a stream) where storing everything isn’t practical.

Time Complexity: O(n) where n is the number of input elements.

Space Complexity: O(k). // this is the key, pick the k elements randomly without loading things in memory

Probability correctness: Each element has equal chance of being chosen.
 */
public class ReservoirSampler {

    public List<Integer> randomPickIndices(List<Integer> nums, int k) {
        List<Integer> result = new ArrayList<>(k);
        Random rand = new Random();

        // Step 1: Fill the reservoir with the first k elements
        for (int i = 0; i < k; i++) {
            result.add(nums.get(i));
        }

        // Step 2: Replace elements with gradually decreasing probability
        for (int i = k; i < nums.size(); i++) {
            int r = rand.nextInt(i);  // Generates a number between 0 and i
            if(r < k) {
                result.set(r, nums.get(i));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(10, 20, 30, 40, 50, 60, 70);
        int k = 3;

        List<Integer> sample = new ReservoirSampler().randomPickIndices(nums, k);
        System.out.println("Random Sample: " + sample);
    }
}
