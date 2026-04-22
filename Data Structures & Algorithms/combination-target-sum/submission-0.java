class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        findCombinations(nums, target, 0, 0, new ArrayList<>(), result);
        return result;
    }

    private void findCombinations(int[] nums, int target, int currentIndex, int currentSum,
        List<Integer> currentElements, List<List<Integer>> result) {
        if (currentIndex >= nums.length) {
            return;
        }

        if (currentSum == target) {
            result.add(new ArrayList<>(currentElements));
            return;
        } else if (currentSum > target) {
            return;
        }

        // choosing the element
        currentElements.add(nums[currentIndex]);
        currentSum += nums[currentIndex];
        findCombinations(nums, target, currentIndex, currentSum, currentElements, result);

        // not choosing element

        currentElements.remove(currentElements.size() - 1);
        currentSum -= nums[currentIndex];
        findCombinations(nums, target, currentIndex + 1, currentSum, currentElements, result);
    }
}
