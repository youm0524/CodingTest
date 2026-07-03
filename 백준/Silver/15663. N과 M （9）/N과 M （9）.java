
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int[] nums;
    static boolean[] visited;
    static int[] path;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        nums = new int[N];
        visited = new boolean[N];
        path = new int[M];

        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums);
        dfs(0);

        System.out.print(sb.toString());
    }

    public static void dfs(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(path[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int prev = -1;
        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            if (prev == nums[i]) continue;

            visited[i] = true;
            path[depth] = nums[i];
            prev = nums[i];

            dfs(depth + 1);

            visited[i] = false;
        }
    }
}
