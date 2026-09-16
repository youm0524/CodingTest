import java.util.*;
class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int m = key.length;
        int n = lock.length;
        int boardsize = 3*n;
        int[][] board = new int[boardsize][boardsize];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[n + i][n + j] = lock[i][j];
            }
        }
        
        // 0도, 90도, 180도, 270도
        for (int r = 0; r < 4; r++) {

            // key를 올릴 수 있는 모든 위치 탐색
            for (int i = 0; i <= boardsize - m; i++) {
                for (int j = 0; j <= boardsize - m; j++) {

                    // key 올리기
                    for (int x = 0; x < m; x++) {
                        for (int y = 0; y < m; y++) {
                            board[i + x][j + y] += key[x][y];
                        }
                    }

                    // 자물쇠 영역 검사
                    if (check(board, n)) {
                        return true;
                    }

                    // 원상복구
                    for (int x = 0; x < m; x++) {
                        for (int y = 0; y < m; y++) {
                            board[i + x][j + y] -= key[x][y];
                        }
                    }
                }
            }

            // 90도 회전
            key = rotate(key);
        }
        
        return false;
    }
    
    public boolean check(int[][] board, int n){
        for(int i = n; i<n*2; i++){
            for(int j = n; j<n*2; j++){
                if(board[i][j]!=1){
                    return false;
                }
            }
        }
        return true;
    }
    public int[][] rotate(int[][] key){
        int m = key.length;
        int[][] result = new int[m][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                result[j][m - 1 - i] = key[i][j];
            }
        }

        return result;
    }
}