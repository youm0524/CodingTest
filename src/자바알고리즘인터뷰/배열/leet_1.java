package 자바알고리즘인터뷰.배열;

import java.util.HashMap;
import java.util.Map;

public class leet_1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numshash = new HashMap<>();
        int[] answer = new int[2];
        for (int i = 0; i < nums.length; i++) {
            numshash.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (numshash.containsKey(target - nums[i]) && i != numshash.get(target - nums[i])) {
                answer[0] = i;
                answer[1] = numshash.get(target - nums[i]);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        leet_1 sol = new leet_1();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = sol.twoSum(nums, target);

        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }
}

