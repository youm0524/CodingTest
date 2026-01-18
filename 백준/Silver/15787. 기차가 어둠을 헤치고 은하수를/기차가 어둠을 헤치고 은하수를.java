
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    private static int[][] train;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        train = new int[N][20];
        int answer = 1;
        for(int k = 1; k<=M; k++){
            int order = sc.nextInt();
            if(order == 1){
                int i = sc.nextInt();
                int x = sc.nextInt();
                order1(i,x);
            }
            else if(order == 2){
                int i = sc.nextInt();
                int x = sc.nextInt();
                order2(i,x);
            }
            else if(order == 3){
                int i = sc.nextInt();
                order3(i);
            }
            else{
                int i = sc.nextInt();
                order4(i);
            }

        }
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 20; j++) {
                sb.append(train[i][j]);
            }
            set.add(sb.toString());
        }
        System.out.println(set.size());
    }

    public static void order1(int i, int x){
        train[i-1][x-1] = 1;
    }
    public static void order2(int i, int x){
        train[i-1][x-1] = 0;
    }
    public static void order3(int i){
        if(train[i-1][19]==1)train[i-1][19]=0;
        for(int j = 19; j>0; j--){
            if(train[i-1][j-1]==1){
                train[i-1][j]=1;
                train[i-1][j-1] = 0;
            }
        }
    }
    public static void order4(int i){
        if(train[i-1][0]==1)train[i-1][0]=0;
       for(int j = 0; j<19; j++){
           if(train[i-1][j+1]==1){
               train[i-1][j] = 1;
               train[i-1][j+1] = 0;
           }
       }
    }
}
