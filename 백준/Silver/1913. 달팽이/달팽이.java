
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[] dx = {1,0,-1,0};
    private static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());
        int num = N*N;
        int[][] ans = new int[N][N];
        int x = 0;
        int y = 0;
        int cnt = 0;
        while(num>=1){
            ans[x][y] = num;
            num--;
            int nx = x + dx[cnt];
            int ny = y + dy[cnt];  // ← dx → dy 수정
            if(nx < 0 || nx >= N || ny < 0 || ny >= N || ans[nx][ny] != 0){
                cnt = (cnt+1)%4;
                nx = x + dx[cnt];
                ny = y + dy[cnt];  // ← dx → dy 수정
            }
            x = nx;
            y = ny;
        }
        int ansX = 0, ansY = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(ans[i][j]).append(" ");
                if (ans[i][j] == target) {
                    ansX = i + 1;
                    ansY = j + 1;
                }
            }
            sb.append("\n");
        }
        sb.append(ansX).append(" ").append(ansY);

        System.out.print(sb.toString());
    }
}
