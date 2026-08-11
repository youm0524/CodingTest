package 정올;

import java.io.*;
import java.util.*;

public class j1912 {
    static List<List<Integer>> graph;
    static boolean[] visited;
    static List<Integer> answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 정점 수
        int M = Integer.parseInt(st.nextToken()); // 간선 수
        visited = new boolean[N+1];
        graph = new ArrayList<>();
        answer = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        //무방향이니까 양쪽에 다 저장
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        //더 작은 순서로 가기 위해서 list 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        visited[1] = true;
        answer.add(1);
        dfs(1);


        for (int x : answer) {
            System.out.print(x + " ");
        }

    }
    public static void dfs(int start){
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int cur = stack.pop();

            if (visited[cur]) continue;

            visited[cur] = true;
            answer.add(cur);

            List<Integer> list = graph.get(cur);

            // 작은 번호부터 방문시키기 위해 역순으로 push
            for (int i = list.size() - 1; i >= 0; i--) {
                int next = list.get(i);

                if (!visited[next]) {
                    stack.push(next);
                }
            }
        }
    }
}