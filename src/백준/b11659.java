package 백준;

import java.util.*;
import java.io.*;

public class b11659{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        arr[0]=0;
        
        for(int i =1; i<N+1;i++){
            arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
        }
        
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int result = arr[end]-arr[start-1];
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
