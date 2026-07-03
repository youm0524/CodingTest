import java.util.*;
import java.lang.StringBuilder;

public class Main {
    static int N, M;
    static int[] nums;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums);

        dfs(0, 0, new ArrayList<>());

        System.out.print(sb.toString());
    }

    static void dfs(int depth, int start, List<Integer> path) {
        if (depth == M) {
            for (int num : path) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        int prev = -1;

        for (int i = start; i < N; i++) {
            if (nums[i] == prev) continue;

            path.add(nums[i]);
            prev = nums[i];

            dfs(depth + 1, i + 1, path);

            path.remove(path.size() - 1);
        }
    }
}
