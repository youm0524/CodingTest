class Solution
{
    public int solution(int [][]board)
    {
        int answer = 1234;

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");
        for(int i = 1; i<board.length; i++){
            for(int j = 1; j<board[0].length; j++){
                if(board[i][j] == 1){
                    board[i][j] = Math.min(
                        Math.min(board[i-1][j],board[i][j-1]),board[i-1][j-1]
                    )+1;
                }
            }
        }
        int tmp = Integer.MIN_VALUE;
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                tmp = Math.max(tmp, board[i][j]);
            }
        }
        answer = tmp*tmp;
        return answer;
    }
}