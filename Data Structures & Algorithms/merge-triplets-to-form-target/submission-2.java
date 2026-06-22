class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean first = false, second = false, third = false;
        for (int[] item : triplets) {
            if (item[0] > target[0] || item[1] > target[1] || item[2] > target[2]) {
                continue;
            }
            if (item[0] == target[0]) {
                first = true;
            }
            if (item[1] == target[1]) {
                second = true;
            }
            if (item[2] == target[2]) {
                third = true;
            }
            if (first && second && third) {
                return true;
            }
        }
        return false;
    }
} //Skip any triplet that exceeds the target,
 //then check if you can collect all three target values from the remaining valid triplets.
