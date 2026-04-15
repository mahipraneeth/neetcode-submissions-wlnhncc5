class Solution {
    public int search(int[] nums, int target) {
        // identify sorted then do comparision
        int i=0, j=nums.length-1;
        while(i<=j && j<nums.length){
            int mid = i + ((j-i)/2);
            if(nums[mid] == target){
                return mid;
            }

            if(nums[i] <= nums[mid]){
                // left side is sorted
                if(target < nums[mid] && target >= nums[i]){
                    j=mid-1;
                }else{
                    i=mid+1;
                }
            }else {
                // right side is sorted
                if(target > nums[mid] && target <= nums[j]){
                    i=mid+1;
                }else{
                    j=mid-1;
                }
            }
        }
        return -1;
    }
}
