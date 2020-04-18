package com.kingluffy.playstation;

/**
 * No.42
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int res = 0;
        if(height.length<3){
            return res;
        }

        int leftIdx = 0;
        int leftMax = height[leftIdx];

        int rightIdx = height.length-1;
        int rightMax = height[rightIdx];

        while(leftIdx<rightIdx){
            if(leftMax<rightMax){
                leftIdx++;
                if(height[leftIdx]<leftMax){
                    res += leftMax-height[leftIdx];
                }
                else {
                    leftMax = height[leftIdx];
                }
            }else{
                rightIdx--;
                if(height[rightIdx]<rightMax){
                    res += rightMax-height[rightIdx];
                }
                else {
                    rightMax = height[rightIdx];
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] in = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        TrappingRainWater water = new TrappingRainWater();
        int res = water.trap(in);
        System.out.println(res);
    }
}
