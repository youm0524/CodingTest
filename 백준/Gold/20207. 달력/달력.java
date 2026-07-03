import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] cnt = new int[366];

        for(int i = 0; i<N; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            for(int d = start; d<=end; d++) {
                cnt[d]++;
            }
        }

        int width = 0;
        int height = 0;
        int answer = 0;
        for(int i = 1; i<=365; i++){
            if(cnt[i]>0){
                width++;
                height = Math.max(height,cnt[i]);
            } else{
                answer+=width*height;
                width = 0;
                height = 0;
            }
        }
        answer+=width*height;
        System.out.println(answer);
    }
}
