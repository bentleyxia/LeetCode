/*
 A message containing letters from A-Z is being encoded to numbers using the
following mapping:
'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of
ways to decode it.

Example 1:
```
Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).
```
 */
public class DecodeWays {
  public int numDecodings(String s) {
    int len = s.length();
    if (len == 0 || s.charAt(0) == '0')
      return 0;
    if (len == 1)
      return 1;
    // ASCII char'0-9' Dex'48-57'
    int dp[] = new int[len + 1];
    dp[0] = 1;
    // begin
    dp[1] = 1;
    for (int i = 2; i < len + 1; i++) {
      int tmp = Integer.parseInt(s.substring(i - 2, i));
      // depend on dp[i-2]
      if (tmp < 27 && tmp > 9)
        dp[i] += dp[i - 2];
      // depend on dp[i-1]
      if (s.charAt(i - 1) != '0')
        dp[i] += dp[i - 1];
    }
    return dp[len];
  };
}