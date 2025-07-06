package 자바알고리즘인터뷰.문자열;

import java.util.*;

public class leet_49 {
    public static void main(String[] args) {
        leet_49 solution = new leet_49();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = solution.groupAnagrams(strs);

        // 결과 출력
        for (List<String> group : result) {
            System.out.println(group);
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> results = new HashMap<>();

        for (String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String key = String.valueOf(c);

            if (!results.containsKey(key)) {
                results.put(key, new ArrayList<>());
            }
            results.get(key).add(s);
        }
        return new ArrayList<>(results.values());
    }
}

