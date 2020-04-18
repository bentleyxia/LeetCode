/* 
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
 */

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        char[] ch = word.toCharArray();
        // first element;
        for(int i = 0; i<board.length; i++){
            for(int j=0; j< board[0].length;j++){
                if(ch[0] == board[i][j]){
                    board[i][j] = '*';  //push 
                    if(bfsSearch(0, i, j, board, ch)){
                        return true;
                    }
                    board[i][j] = ch[0]; //pop (same letter used once)
                }
            }
        }
        return false;
    }
    
    private boolean bfs(int pos, int i, int j, char[][] board, char[] ch){
        if(pos == ch.length){
            return true;
        }
        
        // certify if blow board 
        if(i >= board.length || i < 0|| j >= board[0].length || j < 0){
            return false;
        }
        if(ch[pos] == board[i][j]){
            board[i][j] = '*'; // push 
            if(bfsSearch(pos, i, j, board, ch)){
                return true;
            }
            board[i][j] = ch[pos]; // pop
        }
        return false;
        
    }
    
    
    private boolean bfsSearch(int pos, int i, int j, char[][] board, char[] ch ){
        if( bfs(pos+1, i+1, j, board, ch ) || 
           bfs(pos+1, i-1, j, board, ch )  || 
           bfs(pos+1, i, j+1, board, ch )  || 
           bfs(pos+1, i, j-1, board, ch ) ){
            return true;
        }
        return false;
    }
}