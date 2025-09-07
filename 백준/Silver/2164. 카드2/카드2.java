import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 1; i<N+1; i++){
            queue.add(i);
        }
        while(queue.size() != 1){
            queue.poll();
            int a = queue.poll();
            queue.add(a);
        }
        System.out.println(queue.element());
    }
}
