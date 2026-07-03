import java.util.*;

class Solution {
    int[] best = null;
    int bestDiff = -1;

    public int[] solution(int n, int[] info) {
        int[] cur = new int[11];
        dfs(0, n, info, cur);

        if (bestDiff == -1) return new int[]{-1};
        return best;
    }

    void dfs(int idx, int remain, int[] info, int[] cur) {
        // 끝까지 왔으면 점수 계산 & best 갱신
        if (idx == 11) {
            // 남은 화살은 0점에 몰아넣기
            if (remain > 0) cur[10] += remain;

            evaluateAndUpdate(info, cur);

            // 되돌리기
            if (remain > 0) cur[10] -= remain;
            return;
        }

        // 선택 1) 이 점수를 "이긴다"
        int need = info[idx] + 1;
        if (remain >= need) {
            cur[idx] = need;
            dfs(idx + 1, remain - need, info, cur);
            cur[idx] = 0; // 백트래킹
        }

        // 선택 2) 포기한다 (0발)
        cur[idx] = 0;
        dfs(idx + 1, remain, info, cur);
    }

    void evaluateAndUpdate(int[] info, int[] cur) {
        int ryan = 0;
        int apeach = 0;

        for (int i = 0; i < 11; i++) {
            int score = 10 - i;
            if (cur[i] == 0 && info[i] == 0) continue;

            if (cur[i] > info[i]) ryan += score;
            else apeach += score;
        }

        int diff = ryan - apeach;
        if (diff <= 0) return;

        if (diff > bestDiff) {
            bestDiff = diff;
            best = Arrays.copyOf(cur, 11);
        } else if (diff == bestDiff) {
            // tie-break: 낮은 점수(인덱스 10)부터 더 많이 쏜 배열
            for (int i = 10; i >= 0; i--) {
                if (cur[i] > best[i]) {
                    best = Arrays.copyOf(cur, 11);
                    break;
                } else if (cur[i] < best[i]) {
                    break;
                }
            }
        }
    }
}
