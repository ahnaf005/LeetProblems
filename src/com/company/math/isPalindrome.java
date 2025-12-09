package com.company.math;

import java.util.ArrayList;
import java.util.List;

public class isPalindrome {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        List<Integer> list=new ArrayList<>();
        while(x!=0){
            list.add(x%10);
            x/=10;
        }
        int i=0,j=list.size()-1;
        while(i<j){
            if(list.get(i++) != list.get(j--)){
                return false;
            }
        }
        return true;
    }
}
