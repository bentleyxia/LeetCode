/* 
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */

public class LetterCombinationsOfaPhoneNumber {

    // DFS
    public List<String> letterCombinations(String digits) {
        ArrayList<String> al = new ArrayList<String>();
        StringBuilder sb = new StringBuilder(digits);
        dfs(digits, sb, 0, al);
        return al;
    }

    public final String[] str = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    private void dfs(String s, StringBuilder sb, int i, ArrayList<String> al) {
        if (i == s.length()) {
            if (i > 0)
                al.add(sb.toString());
            return;
        }

        int num = Character.getNumericValue(s.charAt(i)); // current num
        for (int j = 0; j < str[num].length(); j++) { // dfs in a position
            sb.setCharAt(i, str[num].charAt(j)); // pop (operate in current position)
            dfs(s, sb, i + 1, al); // push (operate in next position)
        }

    }


    // BFS
    public List<String> letterCombinations(String digits) {
        ArrayList<String> ans = new ArrayList<String>();
        if (digits.length() > 0)
            ans.add("");

        for (char digit : digits.toCharArray()) { // Search by depth
            ArrayList<String> tmp = new ArrayList<>();
            for (String s : ans) {  // copy and add elements in the end of ans
                for (char ch : str[Character.getNumericValue(digit)].toCharArray()) { // Search by elements
                    tmp.add(s + ch);
                }
            }
            ans = tmp;
        }

        return ans;
    }

    public final String[] str = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

}