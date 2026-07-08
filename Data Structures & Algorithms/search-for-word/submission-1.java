class Solution {
    public boolean exist(char[][] board, String word) {
        int row=board.length;
        int col=board[0].length;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(board[i][j]==word.charAt(0)){
                    if(wordSerach(board, i, j, word, 0, row, col))
                    return true;
                }
            }
        }
        return false;
    }

    public boolean wordSerach(char[][] board, int i, int j, String word,
     int index, int row, int col){
        if(index==word.length())
            return true;
        
        if(!isVisited(i, j, row, col) && board[i][j]==word.charAt(index)){
            char temp = board[i][j];
            board[i][j] = '#';
            
            boolean found = wordSerach(board, i, j+1, word, index+1, row, col) ||
            wordSerach(board, i+1, j, word, index+1, row, col) ||
            wordSerach(board, i, j-1, word, index+1, row, col) ||
            wordSerach(board, i-1, j, word, index+1, row, col);
            
                board[i][j]=temp;
                return found;
             
        } 
        else {
            return false;
        }
    }

    public boolean isVisited(int i, int j, int row, int col){
        if(i>=0 && i<row && j>=0 && j<col)
        return false;
        else
        return true;
    }
    
}
