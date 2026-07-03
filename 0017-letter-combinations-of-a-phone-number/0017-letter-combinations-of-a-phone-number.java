class Solution {
    public String[] letters = {"", "", "abc", "def", "ghi", "kjl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> answer = new ArrayList<>();
        dfs(answer, new StringBuilder(), digits.toCharArray(), 0);
        return answer;
    }

    public void dfs(List<String> answer, StringBuilder sb, char[] digits, int depth){
        if(depth==digits.length){
            answer.add(sb.toString());
            return;
        }
        char[] pick = letters[digits[depth]-'0'].toCharArray();
        for(int i = 0; i<pick.length; i++){
            char c = pick[i];
            sb.append(c);
            dfs(answer,sb,digits,depth+1);
            sb.delete(sb.length() - 1, sb.length());
        }
    }
    

}