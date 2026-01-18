class Solution {
    public static HashMap<Character, String[]> nums;
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.length()==0)return result;
        nums = new HashMap<>();
        nums.put('2',new String[]{"a","b","c"});
        nums.put('3',new String[]{"d","e","f"});
        nums.put('4',new String[]{"g","h","i"});
        nums.put('5',new String[]{"j","k","l"});
        nums.put('6',new String[]{"m","n","o"});
        nums.put('7',new String[]{"p","q","r","s"});
        nums.put('8',new String[]{"t","u","v"});
        nums.put('9',new String[]{"w","x","y","z"});
        dfs(result,digits,0,new StringBuilder());
        return result;



    }
    public void dfs(List<String> result, String digits, int index, StringBuilder path){
        if(path.length()==digits.length()){
            result.add(String.valueOf(path));
            return;
        }

        for(String c: nums.get(digits.charAt(index))){
            dfs(result, digits,index+1,new StringBuilder(path).append(c));
        }
    }

}