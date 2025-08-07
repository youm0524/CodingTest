package 자바알고리즘인터뷰.스택;

import java.util.Arrays;
import java.util.Stack;

public class leetcode_739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                answer[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        leetcode_739 solver = new leetcode_739();
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = solver.dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(result)); // [1, 1, 4, 2, 1, 1, 0, 0]
    }
}

