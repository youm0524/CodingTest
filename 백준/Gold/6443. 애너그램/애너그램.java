import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        List<List<Character>> answer = new ArrayList<>();
        List<Character> path = new ArrayList<>();
        for(int i = 0; i<N; i++){
            String s = sc.next();
            char[] charArr = s.toCharArray();
            Arrays.sort(charArr);
            boolean[] visited =new boolean[s.length()];
            String ss = new String(charArr);
            dfs(answer, path, 0, s.length(), ss, visited);
        }

        for (List<Character> an : answer) {
            StringBuilder sb = new StringBuilder();
            for (char c : an) {
                sb.append(c);
            }
            System.out.println(sb.toString());
        }

    }

    public static void dfs(List<List<Character>> answer, List<Character> path, int depth, int len, String s, boolean[] visited){
        if(depth==len){
            answer.add(new ArrayList<>(path));
            return;
        }
        char prev = '/';
        for(int i = 0; i<s.length(); i++){
            if(prev!=s.charAt(i) && !visited[i]){
                path.add(s.charAt(i));
                prev = s.charAt(i);
                visited[i] = true;
                dfs(answer, path, depth+1, len, s, visited);
                path.remove(path.size()-1);
                visited[i] = false;
            }
        }
    }
}
