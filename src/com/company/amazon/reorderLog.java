package com.company.amazon;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class reorderLog {
    public String[] reorderLogFiles(String[] logs) {
        String[] res = new String[logs.length];
        List<String[]> letterLog = new LinkedList<>();
        LinkedList<String>digitLog = new LinkedList<>();
        for(String str:logs){
            String[] parts = str.split("\\s+");
            String lastPart = parts[parts.length-1];
            if(lastPart.matches("\\d+")){
                digitLog.add(str);
            }else{
                String content = str.substring(parts[0].length()+1);
                letterLog.add(new String[]{parts[0],content});
            }
        }
        letterLog.sort(Comparator.comparing((String[] arr) -> arr[1]).thenComparing(arr->arr[0]));
        int i =0;
        for(int j=0;j<letterLog.size();j++){
            res[i++] = letterLog.get(j)[0] + " "+letterLog.get(j)[1];
        }
        for(int j=0;j<digitLog.size();j++){
            res[i++]=digitLog.get(j);
        }
        return res;
    }
}
