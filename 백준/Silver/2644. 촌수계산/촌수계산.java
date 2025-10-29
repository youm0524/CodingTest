import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine()); // 전체 사람 수
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()); // 촌수 계산 대상 1
        int B = Integer.parseInt(st.nextToken()); // 촌수 계산 대상 2
        int m = Integer.parseInt(br.readLine());  // 관계 개수

        int[][] relations = new int[m][2];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            relations[i][0] = Integer.parseInt(st.nextToken()); // 부모
            relations[i][1] = Integer.parseInt(st.nextToken()); // 자식
        }

        // BFS 준비
        boolean[] visited = new boolean[n + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{A, 0}); // {사람번호, 촌수}

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int person = cur[0];
            int cnt = cur[1];

            if (person == B) { // 목표 찾음
                System.out.println(cnt);
                return;
            }

            visited[person] = true;

            for (int i = 0; i < m; i++) {
                int parent = relations[i][0];
                int child = relations[i][1];

                // 부모 → 자식
                if (parent == person && !visited[child]) {
                    queue.add(new int[]{child, cnt + 1});
                }
                // 자식 → 부모
                else if (child == person && !visited[parent]) {
                    queue.add(new int[]{parent, cnt + 1});
                }
            }
        }

        // 관계가 없는 경우
        System.out.println(-1);
    }
}
