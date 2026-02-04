class Solution {
    boolean[] visiting; // 현재 DFS 경로
    boolean[] visited;  // 처리 완료

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visiting = new boolean[numCourses];
        visited = new boolean[numCourses];

        // 모든 노드에서 DFS 시작
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (!dfs(prerequisites, i)) return false;
            }
        }
        return true;
    }

    private boolean dfs(int[][] prerequisites, int course) {
        // 현재 경로에 다시 들어오면 사이클
        if (visiting[course]) return false;
        if (visited[course]) return true;

        visiting[course] = true;

        for (int i = 0; i < prerequisites.length; i++) {
            if (prerequisites[i][0] == course) {
                if (!dfs(prerequisites, prerequisites[i][1])) {
                    return false;
                }
            }
        }

        visiting[course] = false;
        visited[course] = true;
        return true;
    }
}
