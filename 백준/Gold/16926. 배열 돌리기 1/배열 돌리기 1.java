
import java.util.Scanner;

public class Main {
    static int N,M,R;
    static int layer;
    static int[][] map;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        R = sc.nextInt();
        map = new int[N][M];
        layer = Math.min(N,M)/2;
        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                map[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i<R; i++){
            rotate();
        }
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

    }

    public static void rotate(){
        for(int i = 0; i<layer; i++){
            int x = i;
            int y = i;
            int tmp = map[x][y];
            int idx = 0;
            while(idx<4){
                int nx = x+dx[idx];
                int ny = y+dy[idx];
                if(nx<N-i && ny<M-i && nx>=i && ny>=i){
                    int nextTmp = map[nx][ny];
                    map[nx][ny] = tmp;
                    tmp = nextTmp;
                    x = nx;
                    y = ny;
                }else{
                    idx+=1;
                }
            }
        }
    }
}
