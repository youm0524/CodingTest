class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        boolean[][] graph = new boolean[n + 1][n + 1];

        for (int i = 0; i < results.length; i++) {
            int win = results[i][0];
            int lose = results[i][1];
            graph[win][lose] = true;
        }

        for (int mid = 1; mid <= n; mid++) {
            for (int start = 1; start <= n; start++) {
                for (int end = 1; end <= n; end++) {
                    if (graph[start][mid] && graph[mid][end]) {
                        graph[start][end] = true;
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            int count = 0;

            for (int j = 1; j <= n; j++) {
                if (i == j) continue;

                if (graph[i][j] || graph[j][i]) {
                    count++;
                }
            }

            if (count == n - 1) {
                answer++;
            }
        }

        return answer;
    }
}