package com.company.dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class wordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean [] dp = new boolean[s.length() + 1];
        Set<String> words = new HashSet<>(wordDict);
        dp[0] = true;
        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && words.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
