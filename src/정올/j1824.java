
package 정올;

import java.util.*;
import java.io.*;

public class j1824 {
    static int[][] map = new int[9][9];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        for(int i = 0; i < 9; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 0; j < 9; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        // 정답 출력
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean dfs(int i, int j){
        if(i == 9) return true;
        if(j == 9) return dfs(i+1, 0);

        // 이미 숫자가 있는 칸이라면 다음 칸으로
        if(map[i][j] != 0){
            return dfs(i, j+1);
        }

        // 1~9까지 숫자 넣어보기
        for(int num = 1; num <= 9; num++){
            if(check(i, j, num)){
                map[i][j] = num;

                if(dfs(i, j+1)) return true;

                // 백트래킹
                map[i][j] = 0;
            }
        }

        return false;
    }

    static boolean check(int x, int y, int num){

        // 가로, 세로 검사
        for(int k = 0; k < 9; k++){
            if(map[x][k] == num) return false;
            if(map[k][y] == num) return false;
        }

        // 3×3 정사각형 검사
        int startX = (x / 3) * 3;
        int startY = (y / 3) * 3;

        for(int a = startX; a < startX+3; a++){
            for(int b = startY; b < startY+3; b++){
                if(map[a][b] == num) return false;
            }
        }

        return true;
    }
}
