class Solution {
    public int[] solution(int n, int s) {
        if (n > s) return new int[]{-1};

        int[] answer = new int[n];
        int mod = s / n;
        int re = s % n;

        for (int i = 0; i < n - re; i++) {
            answer[i] = mod;
        }
        for (int i = n - re; i < n; i++) {
            answer[i] = mod + 1;
        }

        return answer;
    }
}