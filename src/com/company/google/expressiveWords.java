package com.company.google;

public class expressiveWords {
    public int expressiveWords(String s, String[] words) {
        int result = 0;

        for (String word : words) {
            if (isStretchy(s, word)) {
                result++;
            }
        }

        return result;
    }

    private boolean isStretchy(String s, String word) {
        int i = 0;
        int j = 0;

        while (i < s.length() && j < word.length()) {
            // Characters must match
            if (s.charAt(i) != word.charAt(j)) {
                return false;
            }

            // Find size of group in s
            int startI = i;
            while (i < s.length() && s.charAt(i) == s.charAt(startI)) {
                i++;
            }

            // Find size of group in word
            int startJ = j;
            while (j < word.length() && word.charAt(j) == word.charAt(startJ)) {
                j++;
            }

            int sCount = i - startI;
            int wordCount = j - startJ;

            // word cannot have more characters than s
            if (wordCount > sCount) {
                return false;
            }

            // If s has extra characters, its group must have size >= 3
            if (sCount > wordCount && sCount < 3) {
                return false;
            }
        }

        // Both strings must have been completely consumed
        return i == s.length() && j == word.length();
    }
}
