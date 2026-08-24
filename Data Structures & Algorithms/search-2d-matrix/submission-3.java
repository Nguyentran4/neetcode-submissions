class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int column = matrix[0].length;

        int l = 0, r = row * column - 1;

        while(l <= r){
            int mid = l + (r - l) / 2;
            int ro = mid / column;
            int co = mid % column;
            if(matrix[ro][co] < target){
                l = mid + 1;
            } else if (matrix[ro][co] > target){
                r = mid - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
