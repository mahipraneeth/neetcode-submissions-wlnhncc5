class Solution {
    public int characterReplacement(String s, int k) {
        int i=0, j=0;
        int max_length=0;
        Map<Character, Integer> visited = new HashMap<>();
        int max_frequency = 0;
        while(j<s.length()){
            int count = visited.getOrDefault(s.charAt(j), 0)+1;
            max_frequency = Math.max(max_frequency, count);
            visited.put(s.charAt(j), count);
            if((j-i+1)-max_frequency > k) {
                visited.put(s.charAt(i), visited.get(s.charAt(i))-1);
                i++;
            }
            max_length = Math.max(max_length, j-i+1);
            j++;
        }
        return max_length;
    }
}
