import java.util.Scanner;

public class Main {
    static int bingo;
    static int[][] board;
    static boolean[][] checked;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        board = new int[6][6];
        checked = new boolean[6][6];
        for(int i = 1; i<6; i++){
            for(int j = 1; j<6; j++){
                int n = sc.nextInt();
                board[i][j] = n;
            }
        }
        int count = 1;
        int[] nums = new int[26];
        for(int i = 1; i<26; i++){
            nums[i] = sc.nextInt();}
        for(int k = 1; k<26; k++) {
            int n = nums[k];
            for (int i = 1; i < 6; i++) {
                for (int j = 1; j < 6; j++) {
                    if (n == board[i][j]) {
                        checked[i][j] = true;
                        //System.out.println("i: " + i + "j: " + j);
                    }
                }
            }
            bingo = 0;
            diagonal();
            width();
            heigth();
            if (checkBingo()) {
                System.out.println(k);
                break;
            }
        }


    }
    public static void diagonal(){
        int cnt = 0;
        for(int i = 1; i<6; i++){
            if(checked[i][i]==true)cnt++;
            //System.out.print("i;"+i+"cnt:"+cnt);
        }
        //System.out.println();
        if(cnt == 5){
            bingo++;
        }
        int idx = 1;
        int cnt2 = 0;
        for(int i = 5;i>0; i--){
            if(checked[i][idx]==true)cnt2++;
            idx++;
        }
        if(cnt2==5){
            bingo++;
        }
    }

    public static void width(){
        for(int i = 1; i<6; i++){
            int cnt = 0;
            for(int j = 1; j<6; j++){
                if(checked[i][j]==true)cnt++;
            }
            if(cnt == 5){
                bingo++;
            }
        }
    }

    public static void heigth(){
        for(int i = 1; i<6; i++){
            int cnt = 0;
            for(int j = 1; j<6; j++){
                if(checked[j][i]==true)cnt++;
            }
            if(cnt == 5){
                bingo++;
            }
        }
    }
    public static boolean checkBingo(){
        if(bingo>=3)return true;
        else return false;
    }
}
