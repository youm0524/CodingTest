
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        HashMap<String,Integer> cars = new HashMap<>();
        int[] out = new int[N+1];
        int answer= 0;

        for(int i = 1; i<=N; i++){
            cars.put(sc.next(),i);
        }

        for(int i = 1; i<=N; i++){
            int n = cars.get(sc.next());
            out[i] = n;
        }

        for(int i = 1; i<=N; i++){
            for(int j = i+1; j<=N; j++){
                if(out[i]>out[j]){
                    answer++;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
