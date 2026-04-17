class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] freq = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> freqs : freqMap.entrySet()) {
            List<Integer> existing = freq[freqs.getValue() - 1];
            if (existing == null) {
                existing = new ArrayList<>();
            }
            existing.add(freqs.getKey());
            freq[freqs.getValue() - 1] = existing;
        }

        int[] res = new int[k];
        int idx = 0;
        for (int i = freq.length - 1; i >= 0 && idx < k; i--) {
            if (freq[i] != null) {
                for (int num : freq[i]) {
                    res[idx++] = num;
                    if (idx == k)
                        break;
                }
            }
        }
        return res;
    }
}
