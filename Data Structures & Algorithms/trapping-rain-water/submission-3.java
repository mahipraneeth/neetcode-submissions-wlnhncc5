class Solution {
    public int trap(int[] height) {
        if(height.length < 3){
            return 0;
        }
        int lMax = height[0];
        int rMax = height[height.length-1];
        int[][] positionConfig = new int[height.length-2][2];

        int leftPointer = 1;
        int rightPointer = height.length-2;
        while(leftPointer < height.length-1){
            positionConfig[leftPointer-1][0] = lMax;
            positionConfig[rightPointer-1][1] = rMax;

            lMax = Math.max(lMax, height[leftPointer]);
            rMax = Math.max(rMax, height[rightPointer]);

            leftPointer++;
            rightPointer--;
        }

        int result=0;
        for(int i=1; i<height.length-1; i++){
            int block_capacity = Math.min(positionConfig[i-1][0], positionConfig[i-1][1]) - height[i];
            if(block_capacity > 0){
                result += block_capacity;
            }
        }

        return result;
    }
}
