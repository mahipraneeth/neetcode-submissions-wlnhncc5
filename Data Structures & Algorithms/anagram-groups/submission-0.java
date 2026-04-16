class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        for(String str : strs){
            int[] charArray = new int[26];
            for(int i=0; i<str.length(); i++){
                int index = str.charAt(i) - 'a';
                charArray[index]+=1;
            }

            String indexedStr = Arrays.toString(charArray);
            List<String> res = result.getOrDefault(indexedStr, new ArrayList<>());
            res.add(str);
            result.put(indexedStr, res);
        }
        return new ArrayList<>(result.values());
    }
}
