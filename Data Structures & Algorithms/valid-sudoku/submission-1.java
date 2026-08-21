class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9] ;
        boolean[][] cols = new boolean[9][9] ;
        boolean[][] boxes = new boolean[9][9] ;

        for(int i = 0 ; i < 9 ; i++){
            for(int j = 0 ; j < 9 ; j++){
                if( board[i][j] != '.'){

                    int num = board[i][j] - '1' ;
                    int box = (i/3) * 3 + (j/3) ;

                    if( rows[i][num] || cols[j][num] || boxes[box][num] ) return false ;

                    rows[i][num] = true ; 
                    cols[j][num] = true ;
                    boxes[box][num] = true ;
                }
            }
        }

        return true ;
    }
}

// “We use 3 boolean arrays to track numbers seen in each row, column, and 3x3 box.
// For every non-empty cell, we convert the digit into an index from 0–8 and compute its box index using (i/3)*3 + (j/3). If the number already exists in the current row, column, or box, we return false. Otherwise, we mark it as seen.”