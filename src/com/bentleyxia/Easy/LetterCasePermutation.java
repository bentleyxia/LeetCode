import java.util.ArrayList;
import java.util.List;

/* 
Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.

Examples:
Input: S = "a1b2"
Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

Input: S = "3z4"
Output: ["3z4", "3Z4"]

Input: S = "12345"
Output: ["12345"]
 */

public class LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        ArrayList<String> al = new ArrayList<>();
        char[] ch = S.toCharArray(); // easy to solve
        dfs(ch, 0, al);
        return al;
    }
    private void dfs(char[] ch, int i,ArrayList<String> al){
        if(i==ch.length){
            al.add(new String(ch)); // (element of al) + 1 , return string
            return;
        }
        dfs(ch, i + 1, al); // push / search next element
        if(!Character.isLetter(ch[i])) return;
        ch[i] ^= (1 << 5);  // pop / change Upper or Lower
        dfs(ch, i + 1, al); // push 
        ch[i] ^= (1 <<5 );  // pop / change to origin 
    }
}