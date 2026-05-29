class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int row = 0; row < board.length; row++){
            Set<Character> seen= new HashSet<>();
            for(int i = 0; i < board[0].length; i++){
                if(board[row][i] == '.') continue;
                if(seen.contains(board[row][i])) return false;
                seen.add(board[row][i]);
            }
        }

        for(int col = 0; col < board[0].length; col++){
            Set<Character> seen = new HashSet<>();
            for(int j = 0; j < board[0].length; j++){
                if(board[j][col] == '.') continue;
                if(seen.contains(board[j][col])) return false;
                seen.add(board[j][col]);
            }
        }

        for(int square = 0; square < 9; square++){
            Set<Character> seen = new HashSet<>();
            for(int r = 0; r < 3; r++){
                for(int c = 0; c < 3; c++){
                    int row = (square / 3) * 3 + r;
                    int col = (square % 3) * 3 + c;
                    if(board[row][col] == '.') continue;
                    if(seen.contains(board[row][col])) return false;
                    seen.add(board[row][col]);
                }
            }
        }

        return true;
    }
}
