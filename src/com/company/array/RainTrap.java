package com.company.array;

import java.util.Stack;

public class RainTrap {
    public int trap(int[] height) {
        int ans=0;
        int n=height.length;
        int [] leftMax=new int[n];
        int [] rightMax=new int[n];
        leftMax[0]=height[0];
        for(int i=1;i<n;i++){
            leftMax[i]=Math.max(leftMax[i-1],height[i]);
        }
        rightMax[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--){
            rightMax[i]=Math.max(rightMax[i+1],height[i]);
        }
        for(int i=1;i<n-1;i++){
            ans+=Math.min(leftMax[i],rightMax[i])-height[i];
        }
        return ans;
    }

    public int trap2(int[] height) {
        int ans=0;
        int n=height.length;
        int current=0;
        Stack<Integer>stack=new Stack<>();
        while(current<n){
            while(!stack.empty() && height[current]>height[stack.peek()]){
                int top=stack.peek();
                stack.pop();
                if(stack.empty()){
                    break;
                }
                int distance=current-stack.peek()-1;
                int boundHeight=Math.min(height[stack.peek()],height[current])-height[top];
                ans+=distance*boundHeight;
            }
            stack.push(current++);
        }
        return ans;
    }
}
