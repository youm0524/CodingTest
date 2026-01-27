
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int answer =0;
    static int[] nums;
    static int N;
    static int S;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        nums = new int[N];
        for(int i= 0; i<N; i++){
            nums[i] = sc.nextInt();
        }

        dfs(0,0);
        if (S == 0) System.out.println(answer - 1);
        else  System.out.println(answer);
    }
    public static void dfs(int sum,int depth){
        if(depth==N){
            if(sum==S ){
                answer++;
            }
            return;
        }
        dfs(sum, depth+1);
        dfs(sum+nums[depth],depth+1);
    }
}
