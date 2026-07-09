package 정올;

import java.io.*;
import java.util.*;

public class j2261 {
    static boolean[] visited;
    static String end;
    static int N;
    static String[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 줄 개수
        int M = Integer.parseInt(st.nextToken()); // 문자열 길이
        visited = new boolean[N];
        arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken())-1;
        int y = Integer.parseInt(st.nextToken())-1;
        end = arr[y];
        String start = arr[x];

        Queue<String[]> queue = new LinkedList<>();
        queue.add(new String[]{arr[x], String.valueOf(x + 1)});
        visited[x] = true;

        String answer = bfs(queue);

        //System.out.println(answer);
        if (answer.equals("-1")) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }

    }
    static String bfs(Queue<String[]> queue){
        while(!queue.isEmpty()){
            String[] tmp = queue.poll();
            String s = tmp[0];
            String path = tmp[1];
            //System.out.println(path);
            if(s.equals(end))return path;
            for(int i = 0; i<N; i++){
                if(!visited[i] && isOneDiff(s,arr[i])){
                    queue.add(new String[]{arr[i], path + " " + (i + 1)});
                    visited[i] = true;
                }
            }
        }
        return "-1";
    }
    static boolean isOneDiff(String a, String b) {
        int diff = 0;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
        }

        return diff == 1;
    }
}