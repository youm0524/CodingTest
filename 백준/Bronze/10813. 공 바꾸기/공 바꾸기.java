import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer,Integer> bisket = new HashMap<>();

        int N = sc.nextInt();
        int M = sc.nextInt();

        for(int i = 1; i<N+1;i++){
            bisket.put(i,i);
        }

        for(int i = 0; i<M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int n = bisket.get(a);
            bisket.put(a,bisket.get(b));
            bisket.put(b,n);
        }

        Set<Integer> keyset = bisket.keySet();
        for(Integer key : keyset)System.out.print(bisket.get(key)+" ");
    }
}
