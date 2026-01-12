import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        
        int len = s.length();
        if (len % 5 != 0 || s.charAt(0) != 'q') {
            System.out.println(-1);
            return;
        }
        
        String quack = "quack";
        boolean[] visited = new boolean[len];
        int ans = 0;
        
        for (int i = 0; i < len; ) {
            if (visited[i]) {
                i++;
                continue;
            }
            
            int cnt = 0;
            int idx = 0;
            for (int j = i; j < len; j++) {
                if (!visited[j] && s.charAt(j) == quack.charAt(idx)) {
                    visited[j] = true;
                    idx = (idx + 1) % 5;
                    cnt++;
                }
            }
            
            if (cnt % 5 != 0) {
                System.out.println(-1);
                return;
            }
            ans++;
        }
        
        for (boolean v : visited) {
            if (!v) {
                System.out.println(-1);
                return;
            }
        }
        
        System.out.println(ans);
    }
}
