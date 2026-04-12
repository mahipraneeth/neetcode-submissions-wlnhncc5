class Solution {
    public int lengthOfLongestSubstring(String s) {
        int lp = 0;
        int rp = 0;
        int max_length = 0;
        Map<Character, Integer> visited = new HashMap<>();
        while(rp<s.length()){
            Character current_char = s.charAt(rp);
            while(visited.containsKey(current_char) && visited.get(current_char)!=0) {
                visited.put(s.charAt(lp), 0);
                lp++;
            }
            visited.put(current_char, 1);
            rp++;
            max_length = Math.max(max_length, rp-lp);
        }
        return max_length;
    }
}
