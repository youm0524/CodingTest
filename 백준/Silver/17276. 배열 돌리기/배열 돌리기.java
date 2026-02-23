import java.util.Scanner;

public class Main {
    static int n = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            n = sc.nextInt();
            int d = sc.nextInt();
            int[][] puzzle = new int[n + 1][n + 1];
            int[][] change = new int[n + 1][n + 1];
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    puzzle[j][k] = sc.nextInt();
                    change[j][k] = puzzle[j][k];
                }
            }
            int repeat = (Math.abs(d) % 360) / 45;
            
            if (d < 0) {
                turn(puzzle, change, repeat);
            } else {
                turn2(puzzle, change, repeat);
            }
        }

    }
    public static void turn(int[][] puzzle, int[][] change, int repeat) {
        int mid = (n+1)/2;
        for(int k = 0; k<repeat; k++) {
            change = new int[n + 1][n + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    change[i][j] = puzzle[i][j];
                }
            }
            for (int i = 1; i <= n; i++) {
                int num = puzzle[i][i];
                int num2 = puzzle[i][mid]; //열
                int num3 = puzzle[n + 1 - i][i];
                int num4 = puzzle[mid][i]; //행
                change[mid][i] = num;
                change[i][i] = num2;
                change[n + 1 - i][mid] = num3;
                change[n + 1 - i][i] = num4;
            }
            puzzle = change;
        }
            for(int i=1 ; i<=n; i++) {
                for (int k = 1; k <= n; k++) {
                    System.out.print(change[i][k] + " ");
                }
                System.out.println();
            }

    }
    public static void turn2(int[][] puzzle, int[][] change, int repeat) {
        int mid = (n+1)/2;
        for(int k = 0; k<repeat; k++) {
            change = new int[n + 1][n + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    change[i][j] = puzzle[i][j];
                }
            }
            for (int i = 1; i <= n; i++) {
                int num = puzzle[i][i];
                int num2 = puzzle[i][mid]; //열
                int num3 = puzzle[n + 1 - i][i];
                int num4 = puzzle[mid][i]; //행
                change[i][mid] = num;
                change[i][n + 1 - i] = num2;
                change[mid][i] = num3;
                change[i][i] = num4;
            }
            puzzle = change;
        }
        for(int i=1 ; i<=n; i++){
            for(int j = 1; j<=n; j++){
                System.out.print(change[i][j]+" ");
            }
            System.out.println();
        }
    }
}
