/*
    Given an integer array nums, find the contiguous subarray
    (containing at least one number) which has the largest sum and return its
    sum.

        **Example**:
    ```
    Input: [-2,1,-3,4,-1,2,1,-5,4],
    Output: 6
    Explanation: [4,-1,2,1] has the largest sum = 6.
    ```
*/

class MaximumSubarray {

  public static int maxSubArray(int[] A) {
    int maxSoFar = A[0], maxEndingHere = A[0];
    for (int i = 1; i < A.length; ++i) {
      maxEndingHere = Math.max(maxEndingHere + A[i], A[i]);
      maxSoFar = Math.max(maxSoFar, maxEndingHere);
    }
    return maxSoFar;
  }

  // DP shouldn't consider relation chain but state transfer from i to j

  public int maxSubArray(final int[] nums) {
    int res = nums[0];
    int tmp = res; // sum of current start index
    for (int i = 1; i < nums.length; i++) {
      tmp = tmp + nums[i];
      // update result
      if (tmp > res) {
        res = tmp;
      }
      // change start index
      if (nums[i] > res) {
        res = nums[i];
        tmp = nums[i];
      } else if (nums[i] > tmp) {
        tmp = nums[i];
      }
    }
    return res;
  }
}