class Solution {
    public boolean isPalindrome(String s) {
        int leftPointer = 0; 
        int rightPointer = s.length()-1;
        while(leftPointer<=rightPointer){
            char lc = s.charAt(leftPointer);
            char rc = s.charAt(rightPointer);
            if(!Character.isLetterOrDigit(lc)){
                leftPointer++;
            }else if(!Character.isLetterOrDigit(rc)){
                rightPointer--;
            }else if(Character.toLowerCase(lc) != Character.toLowerCase(rc)){
                return false;
            }else{
                leftPointer++;
                rightPointer--;
            }
        }
        return true;
    }
}
