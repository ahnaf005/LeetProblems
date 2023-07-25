package com.company.string;

public class MergeString {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder stringBuilder=new StringBuilder();
        int i=0,j=0;
        int len1=word1.length(),len2=word2.length();
        while(i<len1 || j<len2){
            if(i<len1){
                stringBuilder.append(word1.charAt(i++));
            }
            if(j<len2){
                stringBuilder.append(word2.charAt(j++));
            }
        }
        return stringBuilder.toString();
    }
}
