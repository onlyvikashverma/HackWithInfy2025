package HackWithInfy2025.DynamicPrograming;

import java.util.HashMap;

public class SubArraySumEquals {
    public int countSubarraysWithSum(int[] array, int target) {
        HashMap<Integer, Integer> sumFrequency = new HashMap<>();
        sumFrequency.put(0, 1);  // Initial condition: zero sum occurred once

        int runningSum = 0;
        int result = 0;

        for (int value : array) {
            runningSum += value;

            if (sumFrequency.containsKey(runningSum - target)) {
                result += sumFrequency.get(runningSum - target);
            }

            sumFrequency.put(runningSum, sumFrequency.getOrDefault(runningSum, 0) + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        SubArraySumEquals finder = new SubArraySumEquals();
        int[] inputArray = {1, 2, 3};
        int targetSum = 3;
        int total = finder.countSubarraysWithSum(inputArray, targetSum);
        System.out.println("Total subarrays with sum " + targetSum + ": " + total); 
    }
}

