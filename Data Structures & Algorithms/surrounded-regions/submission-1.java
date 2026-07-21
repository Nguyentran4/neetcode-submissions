class Solution {
    public void solve(char[][] board) {
        for(int i =0;i<board.length;i++){
            if(board[i][0]=='O'){//first col
                dfs(i,0,board);
            }
            if(board[i][board[0].length-1]=='O'){//last col
                dfs(i,board[0].length-1,board);
            }
        }
        for(int j =0;j<board[0].length;j++){
            if(board[0][j]=='O'){//first row
                dfs(0,j,board);
            }
            if(board[board.length-1][j]=='O'){//last row
                dfs(board.length-1,j,board);
            }
        }
        for(int i =0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                else if(board[i][j]=='#'){
                    board[i][j]='O';
                }
            }
        }
    }
    public void dfs(int i, int j, char[][] board){
        if(i<0 || j<0 || i==board.length || j==board[0].length || board[i][j]!='O'){
            return;
        }
        board[i][j] = '#';
        dfs(i+1,j,board);
        dfs(i-1,j,board);
        dfs(i,j+1,board);
        dfs(i,j-1,board);
    }
}
