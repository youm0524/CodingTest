import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String,Integer> maps = new TreeMap<>();
        for(int i = 0; i<N; i++){
            String s = br.readLine();
            String[] ss = s.split("\\.");
            String ex = ss[1];
            maps.put(ex,maps.getOrDefault(ex,0)+1);
        }
        
        for(String key : maps.keySet()){
            System.out.println(key+" "+maps.get(key));
            
        }
    }
}