
import java.util.Scanner;

public class Main {
    static int[] dx = {0, 1, 1, -1};
    static int[] dy = {1, 0, 1, 1};
    static int[][] board = new int[19][19];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i<19; i++){
            for(int j = 0; j<19; j++){
                board[i][j] = sc.nextInt();
            }
        }

        int answer = 0;
        for(int i = 0; i<19; i++){
            for(int j = 0; j<19; j++){
                if(board[i][j]==1){
                    answer = count(i,j,1);
                    if(answer == 1) {
                        System.out.println(answer);
                        System.out.println((i+1)+" "+(j+1));
                        return;
                    }
                }else if(board[i][j]==2){
                    answer = count(i,j,2);
                    if(answer == 2 ){
                        System.out.println(answer);
                        System.out.println((i+1)+" "+(j+1));
                        return;
                    }
                }
            }
        }
        System.out.print(answer);
    }
    public static int count(int i, int j, int num){
        for(int k = 0; k < 4; k++){

            int px = i - dx[k];
            int py = j - dy[k];

            // 시작점이 아니면 이 방향 스킵
            if(px >= 0 && px < 19 && py >= 0 && py < 19 && board[px][py] == num)
                continue;

            int cnt = 0;
            int nx = i + dx[k];
            int ny = j + dy[k];

            while(nx >= 0 && nx < 19 && ny >= 0 && ny < 19 && board[nx][ny] == num){
                cnt++;
                nx += dx[k];
                ny += dy[k];
            }

            if(cnt == 4){
                // 육목 방지
                if(nx >= 0 && nx < 19 && ny >= 0 && ny < 19 && board[nx][ny] == num)
                    continue;

                return num;
            }
        }
        return 0;
    }


}
