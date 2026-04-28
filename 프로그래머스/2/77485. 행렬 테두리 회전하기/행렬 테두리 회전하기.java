class Solution {
    public int[][] box;
    public int[] solution(int rows, int columns, int[][] queries) {
        
        box = new int[rows][columns];
        int num = 1;
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<columns; j++){
                box[i][j] = num;
                num++;
            }
        }
        int[] answer = new int[queries.length];
        int idx = 0;
        for(int[] querie : queries){
            answer[idx] = rotate(querie);
            idx++;
        }
        return answer;
    }
    public int rotate(int[] querie){
        int x1 = querie[0]-1;
        int y1 = querie[1]-1;
        int x2 = querie[2]-1;
        int y2 = querie[3]-1;
        int prev = box[x1][y1];
        int min = prev;
        //위
        for(int i = y1+1; i<=y2; i++){
            int tmp = box[x1][i];
            box[x1][i] = prev;
            prev = tmp;
            min = Math.min(prev,min);
        }
        //아래
        for(int i = x1+1; i<=x2; i++){
            int tmp = box[i][y2];
            box[i][y2] = prev;
            prev = tmp;
            min = Math.min(prev,min);
        }
        //왼쪽
        for(int i = y2-1;i>=y1; i--){
            int tmp = box[x2][i];
            box[x2][i] = prev;
            prev = tmp;
            min = Math.min(prev,min);
        }
        for(int i = x2-1; i>=x1; i--){
            int tmp = box[i][y1];
            box[i][y1] = prev;
            prev = tmp;
            min = Math.min(prev,min);
        }
        return min;
    }
}