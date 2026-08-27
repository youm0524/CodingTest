import java.util.*;

class Solution {
    static int n;
    static int answer;
    static List<List<Integer>> keys;

    public int solution(String[][] relation) {
        answer = 0;
        keys = new ArrayList<>();
        n = relation[0].length;

        // 조합 크기를 1개부터 증가
        for (int size = 1; size <= n; size++) {
            dfs(0, size, new ArrayList<>(), relation);
        }

        return answer;
    }

    public void dfs(
            int start,
            int size,
            List<Integer> cols,
            String[][] relation
    ) {

        // 원하는 개수만큼 컬럼 선택
        if (cols.size() == size) {

            // 1. 최소성 검사
            for (List<Integer> key : keys) {
                if (cols.containsAll(key)) {
                    return;
                }
            }

            // 2. 유일성 검사
            Set<String> set = new HashSet<>();

            for (int row = 0; row < relation.length; row++) {
                String value = "";

                for (int col : cols) {
                    value += relation[row][col] + "*";
                }

                set.add(value);
            }

            if (set.size() == relation.length) {
                answer++;
                keys.add(new ArrayList<>(cols));
            }

            return;
        }

        for (int i = start; i < n; i++) {
            cols.add(i);
            dfs(i + 1, size, cols, relation);
            cols.remove(cols.size() - 1);
        }
    }
}