import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int[][] map;
    static int N;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        visited = new boolean[N];

        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                map[i][j] = sc.nextInt();
            }
        }


        for(int start = 0; start<N; start++){
            visited[start] = true;
            dfs(0,start,0,1);
        }
        System.out.print(answer);


    }
    public static void dfs(int cost, int start, int next, int count){
        if(count==N && map[next][start]!=0){
            int total = cost+map[next][start];
            if(total<=answer){
                answer = total;
            }
            return;
        }

        for(int j = 0; j<N; j++){
            if(map[next][j]!=0 && !visited[j]){
                visited[j] = true;
                dfs(cost+map[next][j], start, j, count+1);
                visited[j] = false;
            }

        }
    }
}
