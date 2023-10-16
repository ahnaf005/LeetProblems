package com.company.string;

public class ReverseWords {
    public String reverseWords(String s) {
        StringBuilder result= new StringBuilder();
        String[] words=s.trim().split(" ");
        for(int i= words.length-1;i>=0;i--){
            if(words[i].trim().isEmpty())
                continue;
            result.append(words[i]);
            if(i!=0){
                result.append(" ");
            }
        }
        return result.toString();
    }
}
