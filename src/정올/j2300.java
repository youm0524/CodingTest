package 정올;


import java.io.*;
import java.util.*;

public class j2300 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int left = 0;
        int right = n-1;
        int refA = 0;
        int refB = 0;
        int answer = Integer.MAX_VALUE;
        while(left<right){
            int diff = arr[right] + arr[left];
            if(diff==0){
                refA = arr[left];
                refB = arr[right];
                answer = Math.abs(diff);
                break;
            }
            else if(diff>0){
                if(Math.abs(diff)<answer){
                    answer = Math.abs(diff);
                    refA = arr[left];
                    refB = arr[right];
                }
                right--;
            }
            else{
                if(Math.abs(diff)<answer){
                    answer = Math.abs(diff);
                    refA = arr[left];
                    refB = arr[right];
                }
                left++;
            }

        }
        System.out.println(refA + " " + refB);
    }
}