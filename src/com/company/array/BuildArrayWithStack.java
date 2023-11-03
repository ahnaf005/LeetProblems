package com.company.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class BuildArrayWithStack {
    public List<String> buildArray(int[] target, int n) {
        int i=0,num=1;
        List<String>stackOps=new LinkedList<>();
        while(i<target.length && num<=n){
            if(target[i]==num++){
                i++;
                stackOps.add("Push");
            }else{
                stackOps.add("Push");
                stackOps.add("Pop");
            }
        }
        return stackOps;
    }
}
