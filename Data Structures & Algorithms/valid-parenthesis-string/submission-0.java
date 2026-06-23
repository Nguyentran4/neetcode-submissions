class Solution {
    public boolean checkValidString(String s) {
        int leftMin = 0;
        int leftMax = 0;

        for(Character c : s.toCharArray()){
            if(c == '('){
                leftMin++;
                leftMax++;
            } else if (c == ')'){
                leftMin--;
                leftMax--;
            } else {
                leftMin--;
                leftMax++;
            }

            if(leftMax < 0){ // Too many closing
                return false;
            }

            if(leftMin < 0){
                leftMin = 0;
            }
        }

        return leftMin == 0;
    }
} //"Keep a range of opens; max < 0 = fail, end min = 0 = pass."
