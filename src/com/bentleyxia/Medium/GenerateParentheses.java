/* 
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        ArrayList<String> al = new ArrayList<String>();
        String s = new String();
        dfs(s, n, n, al);
        return al;
    }

    // l is num of "(" , r is num of ")"
    private void dfs(String s, int l, int r, ArrayList<String> al) {
        if (l + r == 0) {
            al.add(s);
            return;
        }
        if (r < l)
            return; // ** : deal with illegal
        if (l > 0)
            dfs(s + "(", l - 1, r, al); // left : push
        if (r > 0)
            dfs(s + ")", l, r - 1, al); // right : left pop then push
    }
}

// 1
// 1 0
// * 0 1 **
// * 0 * 0
