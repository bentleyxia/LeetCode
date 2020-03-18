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

class ThreeSum {
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