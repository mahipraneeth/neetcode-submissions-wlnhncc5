class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> index_stack = new Stack<>();
        index_stack.push(temperatures.length-1);

        int[] result = new int[temperatures.length];
        result[temperatures.length-1]=0;

        int j=temperatures.length-2;
        while(j>=0){
            while(!index_stack.isEmpty() && temperatures[index_stack.peek()] <= temperatures[j]){
                index_stack.pop();
            }
            if(index_stack.isEmpty()){
                result[j] = 0;
            }else{
                result[j] = index_stack.peek() - j;
            }
            index_stack.push(j);
            j--;
        }
        return result;
    }
}
