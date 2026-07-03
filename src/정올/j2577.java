package 정올;

import java.io.*;
import java.util.*;

public class j2577 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int N = arr[0];
        int d = arr[1];
        int k = arr[2];
        int c = arr[3];
        int[] num = new int[N];

        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        int[] nums = new int[2*N];
        for(int i = 0; i<N; i++){
            nums[i] = num[i];
            nums[i+N] = num[i];
        }

        int[] count = new int[d+1];
        int kind = 0;
        int answer = Integer.MIN_VALUE;
        for(int i = 0; i<k; i++){
            if(count[nums[i]]==0)kind++;
            count[nums[i]]++;
            answer= Math.max(answer, kind);
            //System.out.println(answer);
            //System.out.println(set.size());
        }

        for(int i = k; i<2*N; i++){
            int remove = nums[i-k];
            count[remove]--;
            if(count[remove]==0)kind--;

            int add = nums[i];
            if(count[add]==0)kind++;
            count[add]++;

            int total = kind;
            if (count[c] == 0) total++;
            answer = Math.max(answer, total);
            //System.out.println(tmp);
        }

        System.out.println(answer);
    }
}