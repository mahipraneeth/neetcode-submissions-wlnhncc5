class Solution {
    public boolean isValid(String s) {
        Stack<Character> parentheses = new Stack<>();
        Map<Character, Character> closedParentheses = getClosedParentheses();
        for(int i=0; i<s.length(); i++){
            if(closedParentheses.containsKey(s.charAt(i))){
                if(parentheses.isEmpty() || parentheses.pop() != closedParentheses.get(s.charAt(i))){
                    return false;
                }
            }else{
                parentheses.push(s.charAt(i));
            }
        }
        if(parentheses.isEmpty()){
            return true;
        }
        return false;
    }

    private Map<Character, Character> getClosedParentheses(){
        Map<Character, Character> closedParentheses = new HashMap<>();
        closedParentheses.put(')', '(');
        closedParentheses.put('}', '{');
        closedParentheses.put(']', '[');
        return closedParentheses;
    }
}
