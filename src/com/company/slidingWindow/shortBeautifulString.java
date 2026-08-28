package com.company.slidingWindow;

import java.util.ArrayList;
import java.util.List;

public class shortBeautifulString {
    public String shortestBeautifulSubstring(String s, int k) {
        int len = s.length();
        List<Integer> indexOfOnes = new ArrayList<>();
        for(int i = 0; i < len; i++){
            if(s.charAt(i) == '1'){
                indexOfOnes.add(i);
            }
        }
        int resI = 0, resJ = 0;
        int minLen = Integer.MAX_VALUE;
        int totalOnes = indexOfOnes.size();
        for(int i = 0; i <= (totalOnes-k) ; i++){
            int indexI = indexOfOnes.get(i);
            int indexJ = indexOfOnes.get(i+k-1);
            if(indexJ - indexI < minLen){
                minLen = indexJ - indexI;
                resI = indexI;
                resJ = indexJ;
            }else if(indexJ - indexI == minLen){
                if(s.substring(resI, resJ+1).compareTo(s.substring(indexI,indexJ+1)) > 0){
                    resI = indexI;
                    resJ = indexJ;
                }
            }
        }
        return minLen == Integer.MAX_VALUE? "": s.substring(resI, resJ+1);
    }
}
