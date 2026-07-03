import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        int[] dp = new int[N];
        int result = 0;
        for(int i = 0; i<N; i++){
            nums[i] = sc.nextInt();
        }
        for(int i = 0; i<N; i++){
            //기준점

            dp[i] = nums[i];
            //System.out.println("기준"+dp[i]);
            for(int j = 0; j<i; j++){
                if(nums[j]<nums[i]){
                    dp[i] = Math.max(dp[i],nums[i]+dp[j]);
                    //System.out.println(dp[i]);
                }
            }

            result = Math.max(dp[i],result);
            
        }
        System.out.println(result);

    }
}
