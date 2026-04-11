class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        Map<Character, Integer> sFrequency = new HashMap<>();
        Map<Character, Integer> tFrequency = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            sFrequency.put(s.charAt(i), sFrequency.getOrDefault(s.charAt(i),0)+1);
            tFrequency.put(t.charAt(i), tFrequency.getOrDefault(t.charAt(i),0)+1);
        }

        for(Map.Entry<Character, Integer> entry : sFrequency.entrySet()){
            if(!tFrequency.containsKey(entry.getKey()) || !tFrequency.get(entry.getKey()).equals(entry.getValue())){
                return false;
            }
        }
        return true;
    }
}
