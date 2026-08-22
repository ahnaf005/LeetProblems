package com.company.amazon;

import javax.swing.text.AttributeSet;
import java.util.HashMap;
import java.util.Map;

public class minWindow {
    public String minWindow(String s, String t) {
        if(s.length() ==0 || s.length()<t.length())
            return "";
        Map<Character, Integer>dicT = new HashMap<>();
        for(char ch: t.toCharArray()){
            dicT.put(ch,dicT.getOrDefault(ch,0)+1);
        }
        int formed = 0;
        int required = dicT.size();
        int left = 0, right = 0;
        Map<Character,Integer>dicS = new HashMap<>();
        Integer[] values = new Integer[]{null,null, Integer.MAX_VALUE}; //left,right,len
        while(right< s.length()){
            Character ch = s.charAt(right);
            dicS.put(ch, dicS.getOrDefault(ch,0)+1);
            if(dicT.containsKey(ch) && dicS.get(ch).intValue() == dicT.get(ch).intValue()){
                formed++;
            }
            while(left<=right && formed == required){
                int len = right-left+1;
                if(len<values[2]){
                    values[0]=left;
                    values[1]=right;
                    values[2]=len;
                }
                Character leftCh = s.charAt(left);
                dicS.put(leftCh,dicS.get(leftCh)-1);
                if(dicT.containsKey(leftCh) && dicS.get(leftCh) < dicT.get(leftCh)){
                    formed--;
                }
                left++;
            }
            right++;
        }
        return values[2] == Integer.MAX_VALUE? "":s.substring(values[0],values[1]+1);
    }
}
