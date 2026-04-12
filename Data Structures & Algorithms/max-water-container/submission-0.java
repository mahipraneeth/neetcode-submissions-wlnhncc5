class Solution {
    public int maxArea(int[] heights) {
        int lp = 0;
        int rp = heights.length-1;
        int max_water = 0;
        while(lp<rp){
            int water_capacity = Math.min(heights[lp], heights[rp]) * (rp-lp);
            max_water = Math.max(max_water, water_capacity);
            if(heights[lp] < heights[rp]){
                lp++;
            }else{
                rp--;
            }
        } 
        return max_water;
    }
}
