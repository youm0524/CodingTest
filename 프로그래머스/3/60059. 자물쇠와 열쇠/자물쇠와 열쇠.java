class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        int N = lock.length;
        int M = key.length;
        int size = 2*M + N;
        int[][] board = new int[size][size];
        for(int i = M; i<M+N; i++){
            for(int j = M; j<M+N; j++){
                board[i][j] = lock[i-M][j-M];
            }
        }
        for(int r = 0; r<4; r++){
            
            for(int i = 0; i<size-M; i++){
                for(int j = 0; j<size-M; j++){
                    for(int k = 0; k<M; k++){
                        for(int l = 0; l<M; l++){
                            board[i+k][j+l] += key[k][l];
                        }
                    }
                    if(check(board, M, N)){
                        return true;
                    }
                    //원상 복귀
                    for(int k = 0; k<M; k++){
                        for(int l = 0; l<M; l++){
                            board[i+k][j+l] -= key[k][l];
                        }
                    }
                }
            }
            key = rotate(key);
            
        }
        
        return answer;
    }
    public boolean check(int[][] board, int M, int N){
        for(int i = M; i<M+N; i++){
            for(int j = M; j<M+N; j++){
                if(board[i][j] != 1){
                    return false;
                }
            }
        }
        return true;
    }
    public int[][] rotate(int[][] key){

        int M = key.length;
        int[][] result = new int[M][M];

        for(int i = 0; i < M; i++){
            for(int j = 0; j < M; j++){
                result[j][M - 1 - i] = key[i][j];
            }
        }

        return result;
    }
}