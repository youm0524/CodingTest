
import java.util.Scanner;

public class Main {
    static boolean[] visited;
    static String s;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.next();
        visited = new boolean[s.length()];
        solve(0,s.length()-1);
        System.out.println(sb.toString());


    }
    public static void solve(int l, int r){
        if(l>r)return;
        int idx = l;
        //주어진 범위 내에서 제일 작은 애를 찾기
        for(int i = l; i<=r; i++){
            if(s.charAt(i)<s.charAt(idx)){
                idx = i;
            }
        }
        visited[idx] = true;

        for(int i = 0; i<s.length(); i++){
            if(visited[i]){
                sb.append(s.charAt(i));
            }
        }
        sb.append("\n");

        solve(idx+1,r);
        solve(l,idx-1);
    }
}
