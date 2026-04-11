class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> visited = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(visited.containsKey(target-nums[i])){
                int[] result = {visited.get(target-nums[i]), i};
                return result;
            }
            visited.put(nums[i], i);
        }
        return null;
    }
}
