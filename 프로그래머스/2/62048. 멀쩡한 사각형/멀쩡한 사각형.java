class Solution {
    public long solution(int w, int h) {
        long answer = (long)w * h;
        long gcd = gcd(w,h);
        long minus = w + h - gcd;
        answer-=minus;
        return answer;
    }
    public long gcd(long a, long b){
        long remain;
        while(b!=0){
            long c = a % b;
            a = b;
            b = c;
        }
        return a;
    }
}