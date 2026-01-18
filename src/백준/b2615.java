package 백준;

import java.util.Scanner;

public class b2615 {
    static int[][] map;
    static boolean[][] visited = new boolean[19][19];
    static int[] dx = {0, 1, 1, -1};
    static int[] dy = {1, 0, 1, 1};
    static int count = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        map = new int[19][19];

        for(int i = 0; i<19; i++){
            for(int j = 0; j<19;j++){
                map[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i<19; i++){
            for(int j = 0; j<19; j++){
                if(map[i][j]==0)continue;
                int color = map[i][j];

                for(int k = 0; k<4; k++){
                    int nx = i+dx[k];
                    int ny = j+dy[k];
                    int cnt = 1;
                    while(nx>=0 && nx<19 && ny>=0 && ny<19 && map[nx][ny]==color){
                        cnt++;
                        nx+=dx[k];
                        ny+=dy[k];
                    }
                    if(cnt == 5){
                        int px = i-dx[k];
                        int py = i-dy[k];
                        if(px >= 0 && px < 19 && py >= 0 && py < 19 && map[px][py] == color)continue;
                        System.out.println(color);
                        System.out.println((i + 1) + " " + (j + 1));
                        return;
                    }
                }

            }
        }
        System.out.println(0);


    }

}
