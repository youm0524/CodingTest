class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;

        for (long x = 1; x <= r2; x++) {

            // 큰 원에서 가능한 y 최댓값
            long maxY = (long) Math.sqrt((long) r2 * r2 - x * x);

            // 작은 원에서 가능한 y 최솟값
            long minY = (long) Math.ceil(
                Math.sqrt(Math.max(0L, (long) r1 * r1 - x * x))
            );

            // 가능한 정수 좌표 개수
            answer += maxY - minY + 1;
        }

        return answer * 4;
    }
}