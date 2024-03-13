package 프로그래머스.level0;

public class 지뢰 {class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int[] arr1 = new int[]{0,-1,-1,-1,0,1,1,1};
        int[] arr2 = new int[]{-1,-1,0,1,1,1,0,-1};

        for(int i = 0; i<board.length; i++){
            for(int j = 0;j<board[i].length; j++){
                if(board[i][j] == 1){
                    for(int k = 0;k<8;k++){
                        int dx = i + arr1[k];
                        int dy = j + arr2[k];
                        if(dx>=0 && dy>=0 && dx<=board.length-1
                                && dy<=board[i].length-1 && board[dx][dy]!=1)
                            board[dx][dy] = 2;
                    }
                }
            }
        }

        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[i].length; j++){
                if(board[i][j] == 0 ){
                    answer++;
                }
            }
        }
        return answer;
    }
}
}
