import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 행별 누적합
        int[][] map = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int val = Integer.parseInt(st.nextToken());
                map[i][j] = map[i][j - 1] + val;
            }
        }

        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i<M; i++){
            int answer = 0;
            st = new StringTokenizer(br.readLine()); 
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            for(int j = a; j<=c; j++){
                answer += map[j][d]-map[j][b-1];
            }
            sb.append(answer).append("\n");
        }
        
        System.out.print(sb.toString());
    }
}
