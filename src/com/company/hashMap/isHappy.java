package com.company.hashMap;

import java.util.HashSet;
import java.util.Set;

public class isHappy {
    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();
        while(true){
            if(n==1) {
                return true;
            }
            if(visited.contains(n)){
                return false;
            }
            visited.add(n);
            int sqSum = 0;
            while(n!=0) {
                int tmp = n%10;
                sqSum+=(tmp*tmp);
                n/=10;
            }
            n = sqSum;
        }
    }
}
