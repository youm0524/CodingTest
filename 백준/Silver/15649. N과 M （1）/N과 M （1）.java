
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(N, M, result, path);

        StringBuilder sb = new StringBuilder();
        for (List<Integer> re : result) {
            for (int i = 0; i < re.size(); i++) {
                sb.append(re.get(i));
                if (i < re.size() - 1) sb.append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }

    public static void dfs(int N, int M, List<List<Integer>> result, List<Integer> path) {
        if (path.size() == M) {
            result.add(new ArrayList<>(path));
        }

        for (int i = 1; i <= N; i++) {
            if (!path.contains(i)) {
                path.add(i);
                dfs(N, M, result, path);
                path.remove(path.size() - 1);
            }
        }
    }
}
