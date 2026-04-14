class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()){
            return "";
        }

        Map<Character, Integer> tfreq = new HashMap<>();
        for(int i=0; i<t.length(); i++){
            tfreq.put(t.charAt(i), tfreq.getOrDefault(t.charAt(i), 0)+1);
        }

        Map<Character, Integer> sfreq = new HashMap<>();
        int lp=0, rp=0;
        int minimum_lp=-1;
        int minimum_rp=-1;
        while(rp<s.length()){
            sfreq.put(s.charAt(rp), sfreq.getOrDefault(s.charAt(rp), 0)+1);
            while(checkAllCharactersPresent(tfreq, sfreq)){
                if((minimum_lp < 0 || minimum_rp < 0) || (minimum_rp-minimum_lp+1) > (rp-lp+1)){
                    minimum_lp = lp;
                    minimum_rp = rp;
                }
                sfreq.put(s.charAt(lp), sfreq.get(s.charAt(lp))-1);
                if(sfreq.get(s.charAt(lp)) <= 0){
                    sfreq.remove(s.charAt(lp));
                }
                lp++;
            }
            rp++;
        }
        if(minimum_lp < 0 || minimum_rp < 0){
            return "";
        }
        return s.substring(minimum_lp, minimum_rp+1);
    }

    private boolean checkAllCharactersPresent(Map<Character, Integer> tfreq, Map<Character, Integer> sfreq){
        for(Map.Entry<Character, Integer> tmap: tfreq.entrySet()){
            if(!sfreq.containsKey(tmap.getKey()) || sfreq.get(tmap.getKey()) < tmap.getValue()){
                return false;
            }
        }
        return true;
    }
}
