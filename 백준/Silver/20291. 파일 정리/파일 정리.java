import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> count = new HashMap<>();

        for(int i = 0; i<N; i++){
            String s = br.readLine();
            int index = s.indexOf(".");
            String cut = s.substring(index+1);
            count.put(cut,count.getOrDefault(cut,0)+1);
        }
        List<String> keySet = new ArrayList<>(count.keySet());

        Collections.sort(keySet);

        for(String key: keySet){
            System.out.print(key+" ");
            System.out.print(count.get(key));
            System.out.println();
        }
    }
}
