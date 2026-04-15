class Solution {
    public int findMin(int[] nums) {
        int l=0;
        int r=nums.length-1;
        int mid = (r-l)/2;
        while(l!=mid && r!=mid){
            if(nums[mid] > nums[l] && nums[mid] > nums[r]){
                l = mid;
            }else{
                r = mid;
            }
            mid = l + ((r-l)/2);
        }
        return nums[l] > nums[r] ? nums[r] : nums[l];
    }
}
