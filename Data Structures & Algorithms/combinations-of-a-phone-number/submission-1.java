class Solution {
    HashMap<Integer, String> map;
    List<String> ans = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits==null || digits.length()==0)
        return new ArrayList<>();
        map = new HashMap<>();
        map.put(0,"");
        map.put(1,"");
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        combine(digits, new StringBuilder(), 0);
        return ans;
    }

    public void combine(String digits, StringBuilder sb, int i){
        if(i==digits.length()){
            ans.add(sb.toString());
            return;
        }
        String s = map.get(digits.charAt(i)-'0');
        for(int id=0;id<s.length();id++){
            char ch = s.charAt(id);
            sb.append(ch);
            combine(digits, sb, i+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
