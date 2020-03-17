package com.bentleyxia.Medium;

import java.io.*;
import java.util.*;

/* Given an array nums of n integers, are there elements a, b, c in nums such
that $a + b + c = 0$? Find all unique triplets in the array which gives the sum
of zero.

Note:

The solution set must not contain duplicate triplets.

**Example**:

Given array nums = [-1, 0, 1, 2, -1, -4],
```
A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
```
*/

class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();
        int len = num.length;
        if (len < 3)
            return res;
        for (int i = 0; i < len - 2; i++) {
            if (num[i] > 0)
                break;
            if (i == 0 || num[i] != num[i - 1]) {
                int lo = i + 1, hi = len - 1, sum = -num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo + 1])
                            lo++;
                        while (lo < hi && num[hi] == num[hi - 1])
                            hi--;
                        lo++;
                        hi--;
                    } else if (num[lo] + num[hi] < sum)
                        lo++;
                    else
                        hi--;
                }
            }
        }
        return res;
    }
}

public class ThreeSum {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static String integerArrayListToString(List<Integer> nums,
                                                  int length) {
        if (length == 0) {
            return "[]";
        }

        StringBuilder result = new StringBuilder();
        for (int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result.append(Integer.toString(number)).append(", ");
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }

    public static String int2dListToString(List<List<Integer>> nums) {
        StringBuilder sb = new StringBuilder("[");
        for (List<Integer> list : nums) {
            sb.append(integerArrayListToString(list));
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);

            List<List<Integer>> ret = new Solution().threeSum(nums);

            String out = int2dListToString(ret);

            System.out.print(out);
        }
    }
}
