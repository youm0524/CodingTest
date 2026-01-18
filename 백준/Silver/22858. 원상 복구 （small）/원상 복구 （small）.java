import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] D = new int[N + 1];
        int[] S = new int[N + 1];
        int[] P = new int[N + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i<=N ; i++){
            D[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = 0; i<K; i++){
            for(int j = 1; j<=N; j++){
                int M = D[j];
                P[M] = S[j];
            }
            for(int k = 1; k<=N; k++) S[k] = P[k];
            
        }
        
        for(int i = 1; i<N+1; i++){
            System.out.print(P[i]+" ");
        }
        
    }
}