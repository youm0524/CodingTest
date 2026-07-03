class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;
        int[] answer = new int[2];
        while(left<=right){
            int num = numbers[left]+numbers[right];
            if(num<target){
                left++;
            }
            else if(num>target){
                right--;
            }
            else if(num==target){
                answer[0] = left+1;
                answer[1] = right+1;
                break;
            }
        }
        return answer;
        
    }
}