class Solution {
    static int[] answer = new int[2];
    public boolean recurs(int[][] arr, int x, int y, int size, int val){
        for(int i = x; i<x+size; i++){
            for(int j = y; j<y+size; j++){
                if(arr[i][j]!=val){
                    return false;
                }
            }
        }
        return true;
    }
    public void cnt(int[][] arr, int x, int y, int size){
        if(recurs(arr, x, y, size, arr[x][y])){
            if(arr[x][y]==1)answer[1]++;
            else answer[0]++;
            return;
        }
        cnt(arr, x, y, size/2);
        cnt(arr, x, y+size/2, size/2);
        cnt(arr, x+size/2, y, size/2);
        cnt(arr, x+size/2, y+size/2, size/2);
    }
    public int[] solution(int[][] arr) {
        cnt(arr, 0,0, arr.length);
        return answer;
    }
}