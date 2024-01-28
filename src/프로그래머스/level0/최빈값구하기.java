package 프로그래머스.level0;

public class 최빈값구하기 {
    class Solution {
        public int solution(int[] array) {
            int[] nums = new int[1000];

            for(int num : array){
                nums[num]++;
            }
            // for(int num : nums){
            //     System.out.println(num);
            // }
            int max = -2;
            int maxIndex = -1;
            for(int i = 0; i<1000; i++){
                if(nums[i]>max){
                    max = nums[i];
                    maxIndex = i;
                }
            }
            int check = 0;
            for(int num:nums){
                if(max == num){
                    check++;
                    if(check>=2)
                        return -1;
                }
            }
            return maxIndex;
        }
    }
}
