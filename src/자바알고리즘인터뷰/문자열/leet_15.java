package 자바알고리즘인터뷰.문자열;

import java.util.*;

public class leet_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    results.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        leet_15 sol = new leet_15();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = sol.threeSum(nums);
        System.out.println(result);
    }
}

