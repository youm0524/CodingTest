class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String num = Integer.toString(n, k);

        String[] arr = num.split("0+");  // 0 하나 이상 기준으로 자르기

        for (String s : arr) {
            if (s.equals("")) continue;   // 빈 문자열 제외

            long val = Long.parseLong(s);
            if (isPrime(val)) answer++;
        }

        return answer;
    }

    public boolean isPrime(long num) {
        if (num < 2) return false;
        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}