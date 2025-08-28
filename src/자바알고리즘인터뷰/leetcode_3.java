import java.util.HashMap;

public class leetcode_3 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> used = new HashMap<>();

        int max = 0;
        int left = 0;
        int right = 0;

        for (char c : s.toCharArray()) {
            if (used.containsKey(c) && left <= used.get(c)) {
                left = used.get(c) + 1;
            } else {
                max = Math.max(max, right - left + 1);
            }
            used.put(c, right);
            right++;
        }

        return max;
    }

    // 테스트용 main 메서드 (원하면 추가)
    public static void main(String[] args) {
        leetcode_3 solution = new leetcode_3();
        String input = "abcabcbb";
        System.out.println(solution.lengthOfLongestSubstring(input)); // 결과: 3
    }
}
