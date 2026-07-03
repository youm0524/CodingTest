package 정올;

import java.io.*;
import java.util.*;

public class j2497 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int currentSum = 0;
        for(int i = 0; i<k; i++){
            currentSum+=arr[i];
        }
        int max = currentSum;
        for(int i = k; i<arr.length;i++){
            currentSum = currentSum-arr[i-k]+arr[i];
            max = Math.max(max, currentSum);
        }
        System.out.println(max);
    }
}
