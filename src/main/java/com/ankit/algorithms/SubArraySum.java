package com.ankit.algorithms;

import java.util.HashMap;

/**
 *
 * Given an unsorted array of integers, find the number of subarrays having a sum exactly equal to a given number k.
 *         Examples:
 *
 *         Input : arr[] = {10, 2, -2, -20, 10}, k = -10
 *         Output : 3
 *         Explanation: Subarrays: arr[0…3], arr[1…4], arr[3..4] have a sum exactly equal to -10.
 *
 *         Input : arr[] = {9, 4, 20, 3, 10, 5}, k = 33
 *         Output : 2
 *         Explanation: Subarrays : arr[0…2], arr[2…4] have a sum exactly equal to 33.
 *
 */
public class SubArraySum {

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{4,3,-7,1,6,-14,14}, 7));
        System.out.println(subarraySum(new int[]{10,2,-2,-20,10}, -10));
    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap< Integer, Integer > map = new HashMap < > ();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

}
