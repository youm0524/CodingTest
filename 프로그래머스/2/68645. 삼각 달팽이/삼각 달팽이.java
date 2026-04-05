import java.util.*;
class Solution {
    public int[] solution(int n) {
        int[] dx = {1,0,-1};
        int[] dy = {0,1,-1};
        int num = 1;
        int[][] board = new int[n+1][n+1];
        int x = 0;
        int y = 0;
        int idx = 0;
        int size = n;
        while(size>=1){
            System.out.println(size);
            for(int i = 0; i<size; i++){
                board[x][y] = num;
                //System.out.println(i+"x,y"+x+" "+y+" "+board[x][y]);
                //System.out.println("x,y"+x+" "+ny+" "+board[x][y]);
                num++;
                int nx = x + dx[idx];
                int ny = y + dy[idx];

                if(nx < 0 || ny < 0 || nx >= n || ny >= n || board[nx][ny] != 0){
                    idx = (idx + 1) % 3;
                    nx = x + dx[idx];
                    ny = y + dy[idx];
                }

                x = nx;
                y = ny;
            }
            size--;
        }
        int index = 0;
        List<Integer> an = new ArrayList<>();

        for(int i = 0; i<n; i++){
            for(int j =0; j<n; j++){
                if(board[i][j]!=0) {
                    an.add(board[i][j]);
                } 
            }
        }
        int[] answer = an.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
        return answer;
    }
}