import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;
        int time = 0;
        int idx = 0;

        while (idx < truck_weights.length) {
            // 1초 시작

            // 다리 꽉 찼으면 트럭 하나 나감
            if (queue.size() == bridge_length) {
                sum -= queue.poll();
            }

            // 새 트럭이 올라갈 수 있으면
            if (sum + truck_weights[idx] <= weight) {
                queue.add(truck_weights[idx]);
                sum += truck_weights[idx];
                idx++;
            } else {
                // 못 올라가면 0
                queue.add(0);
            }

            time++; // ★ 무조건 여기서만 증가
        }

        // 마지막 트럭들 빠져나가는 시간
        return time + bridge_length;
    }
}
