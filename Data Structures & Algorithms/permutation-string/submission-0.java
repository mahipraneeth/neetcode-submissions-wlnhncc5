class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()){
            return false;
        }
        Map<Character, Integer> s1FrequencyMap = new HashMap<>();
        Map<Character, Integer> s2FrequencyMap = new HashMap<>();

        for(int i=0; i<s1.length(); i++){
            s1FrequencyMap.put(s1.charAt(i), s1FrequencyMap.getOrDefault(s1.charAt(i), 0)+1);
        }

        int i=0; 
        int j=0;
        while(j<s2.length()){
            s2FrequencyMap.put(s2.charAt(j), s2FrequencyMap.getOrDefault(s2.charAt(j), 0)+1);
            while(s2FrequencyMap.get(s2.charAt(j)) > s1FrequencyMap.getOrDefault(s2.charAt(j), 0)){
                s2FrequencyMap.put(s2.charAt(i), s2FrequencyMap.get(s2.charAt(i))-1);
                i++;
            }
            if(j-i+1 == s1.length()){
                return true;
            }
            j++;
        }

        return false;
    }
}
