
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    static int[][] seat;
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int M = sc.nextInt();
        seat = new int[N+1][21];

        for(int i = 0; i<M; i++){
            int a = sc.nextInt();

            if(a == 1){
                int b = sc.nextInt();
                int c = sc.nextInt();
                num1(b,c);
            }
            else if(a == 2){
                int b = sc.nextInt();
                int c = sc.nextInt();
                num2(b,c);
            }
            else if(a == 3){
                int b = sc.nextInt();
                num3(b);
            }
            else{
                int b = sc.nextInt();
                num4(b);
            }
        }
        HashSet<String> set = new HashSet<>();
        for(int i = 1; i<=N; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 1; j<=20; j++){
                sb.append(seat[i][j]);
            }
            set.add(sb.toString());

        }
        System.out.println(set.size());
    }
    static void num1(int t, int s){
        seat[t][s] = 1;
    }
    static void num2(int t, int s){
        seat[t][s] = 0;

    }
    static void num3(int a){
        if(seat[a][20]==1)seat[a][20] = 0;
        for(int i = 20; i>=2; i--){
            if(seat[a][i-1]==1){
                seat[a][i]=1;
                seat[a][i-1] = 0;
            }
        }

    }
    static void num4(int a){
        if(seat[a][1]==1)seat[a][1]=0;
        for(int i = 1; i<20; i++){
            if(seat[a][i+1]==1){
                seat[a][i] = 1;
                seat[a][i+1] = 0;
            }
        }
    }
}
