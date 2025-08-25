import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine().trim());
        int[] A = new int[N + 1];      // 1-indexed
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) A[i] = Integer.parseInt(st.nextToken());

        int[] pref = new int[N + 1];   // pref[i] = 2..i 중 A[i-1] > A[i]의 누적 개수
        for (int i = 2; i <= N; i++) {
            pref[i] = pref[i - 1] + (A[i - 1] > A[i] ? 1 : 0);
        }

        int Q = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        for (int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            // 실수 개수 = L..R-1 사이의 (A[i] > A[i+1]) 개수 = pref[R] - pref[L]
            sb.append(pref[R] - pref[L]).append('\n');
        }
        System.out.print(sb.toString());
    }
}
