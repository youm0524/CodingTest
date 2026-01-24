import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(result, path, N, M);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (List<Integer> re : result) {
            for (int i = 0; i < re.size(); i++) {
                bw.write(re.get(i) + (i < re.size() - 1 ? " " : ""));
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    public static void dfs(List<List<Integer>> result, List<Integer> path, int N, int M) {
        if (path.size() == M) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 1; i <= N; i++) {  // N 고정!
            path.add(i);
            dfs(result, path, N, M);     // N 전달!
            path.remove(path.size() - 1);
        }
    }
}
