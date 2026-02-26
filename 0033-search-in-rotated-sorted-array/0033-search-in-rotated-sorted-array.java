class Solution {
    public int search(int[] nums, int target) {
        //pivot을 찾는 과정 
        int answer = -1;
        int first = nums[0];
        int left = 0; int right = nums.length-1;
        int pivot = 0;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]<first){
                pivot = mid;
                right = mid-1;
            }
            else left = mid+1;
        }
        System.out.println(pivot);
        left = pivot; right = nums.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]<target)left = mid+1;
            else if(nums[mid]>target) right = mid-1;
            else if(nums[mid]==target) return mid;
        }
        left = 0; right = pivot-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]<target) left = mid+1;
            else if(nums[mid]>target) right = mid-1;
            else if(nums[mid]==target) return mid;
        }

        return answer;
        
    }
}