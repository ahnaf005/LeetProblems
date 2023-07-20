package com.company.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> list = new ArrayList<>();
        for (int i : asteroids) {
            list.add(i);
        }
        int index=list.size()-2;
        while(index>=0){
            int firstElem=list.get(index);
            int secondElem=list.get(index+1);
            if(firstElem>0 && secondElem<0){
                if(Math.abs(firstElem)== Math.abs(secondElem)){
                    list.remove(index);
                    list.remove(index);
                }else {
                    if (Math.abs(firstElem) < Math.abs(secondElem)) {
                        list.set(index, secondElem);
                    }
                    list.remove(index + 1);
                }
                index=list.size()-2;
            }else{
                index--;
            }
        }
        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    /*public int[] asteroidCollision2(int[] asteroids) {
        Stack<Integer>stack=new Stack<>();
        for(int item:asteroids){
            if(item>0 || stack.peek()<0){
                stack.push(item);
            }else{
                while (!stack.isEmpty()) {
                    if(stack.peek()>0 && item<0) {
                        if (Math.abs(stack.peek()) < Math.abs(item)) {
                            stack.pop();
                            stack.push(item);
                        } else if (Math.abs(stack.peek()) == Math.abs(item)) {
                            stack.pop();
                            break;
                        } else {
                            break;
                        }
                    }else{
                        break;
                    }
                }
            }
        }
        int[] result=new int[stack.size()];
        for(int i=result.length-1;i>=0;i--){
            result[i]=stack.pop();
        }
        return result;
    }*/
}
