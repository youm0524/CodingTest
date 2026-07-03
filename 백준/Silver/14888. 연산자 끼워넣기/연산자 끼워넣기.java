
import java.util.Scanner;

public class Main {
    static int[] nums;
    static int N;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int plus,minus,multi,divide;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        nums = new int[N];

        for(int i =0 ; i<N; i++){
            nums[i] = sc.nextInt();
        }

        plus = sc.nextInt();
        minus = sc.nextInt();
        multi = sc.nextInt();
        divide = sc.nextInt();
        dfs(0,nums[0]);
        
        System.out.println(max);
        System.out.println(min);
    }
    public static void dfs(int depth,int sum){
        if(depth == N-1){
            if(sum>max)max = sum;
            if(sum<min)min = sum;
            return;
        }
        if(plus!=0){
            plus -=1;
            dfs(depth+1, sum+nums[depth+1]);
            plus+=1;
        }
        if(minus!=0){
            minus-=1;
            dfs(depth+1, sum-nums[depth+1]);
            minus+=1;
        }
        if(multi!=0){
            multi-=1;
            dfs(depth+1, sum*nums[depth+1]);
            multi+=1;
        }
        if(divide!=0){
            divide-=1;
            dfs(depth+1, sum/nums[depth+1]);
            divide+=1;
        }
    }
}
