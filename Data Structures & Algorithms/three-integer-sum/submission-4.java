class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        for(int i=0; i<nums.length-2; i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            int target = 0-nums[i];
            twoSum(i+1, nums, target, results);
        }
        return results;
    }

    private void twoSum(int leftPointer, int[] nums, int target, List<List<Integer>> results){
        int rightPointer = nums.length-1;
        while(leftPointer<rightPointer){
            int sum = nums[leftPointer] + nums[rightPointer];
            if(sum == target){
                results.add(Arrays.asList(0-target, nums[leftPointer], nums[rightPointer]));
                leftPointer++;
                rightPointer--;

                while(leftPointer<rightPointer && nums[leftPointer] == nums[leftPointer-1]) {
                    leftPointer++;
                }

                while(leftPointer<rightPointer && nums[rightPointer] == nums[rightPointer+1]) {
                    rightPointer--;
                }

            }else if(sum > target){
                rightPointer--;
            }else{
                leftPointer++;
            }
        }
    }
}
