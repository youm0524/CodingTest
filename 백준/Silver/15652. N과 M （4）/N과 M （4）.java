
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<List<Integer>> answer = new ArrayList<>();
    static int M;
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        dfs(1,new ArrayList<>(),0);
        for(List<Integer> li : answer){
            for(int num : li){
                System.out.print(num + " ");
            }
            System.out.println();
        }

    }
    public static void dfs(int start, List<Integer> path,int cnt){
        if(cnt==M){
            answer.add(new ArrayList<>(path));
            return;
        }

        for(int i = start; i<=N; i++){
            path.add(i);
            dfs(i, path,cnt+1);
            path.remove(path.size()-1);
        }
    }
}
