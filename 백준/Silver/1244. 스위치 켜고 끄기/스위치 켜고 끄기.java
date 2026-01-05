
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] status = new int[N+1];
        for(int i = 1; i<N+1; i++){
            status[i] = sc.nextInt();
        }
        int M = sc.nextInt();
        for(int i = 0; i<M; i++){
            int gender = sc.nextInt();
            if(gender == 1){
                int a = sc.nextInt();
                for(int j =1 ;j<N+1; j++){
                    if(j%a==0){
                        if(status[j] == 1)status[j] =0;
                        else status[j] = 1;
                    }
                }
//                for(int k = 1; k<N+1; k++){
//                    System.out.println(status[k]);
//                }
            }
            else{
                int b = sc.nextInt();
                int right = b;
                int left = b;
                //기존 스위치
                status[b] = status[b]== 1?0:1;
                // 좌우 대칭인 동안 범위 확장
                while (left - 1 >= 1 && right + 1 <= N && status[left - 1] == status[right + 1]) {
                    left--;
                    right++;
                    status[left] = status[left] == 1 ? 0 : 1;
                    status[right] = status[right] == 1 ? 0 : 1;
                }

            }
        }
        for (int i = 1; i < N + 1; i++) {
            System.out.print(status[i] + " ");
            if (i % 20 == 0) System.out.println();
        }
    }
}
