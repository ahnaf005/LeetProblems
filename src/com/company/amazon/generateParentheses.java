package com.company.amazon;

import java.util.ArrayList;
import java.util.List;

public class generateParentheses {
    private List<String> allValidParentheses;
    public List<String> generateParenthesis(int n) {
        allValidParentheses = new ArrayList<>();
        generateValidCombinations(n, 0, "");
        return allValidParentheses;
    }

    private void generateValidCombinations(int remainingOpenBrackets, int unclosedBrackets, String currentCombination) {
        // Base case: no more brackets to add and all brackets are closed
        if (remainingOpenBrackets == 0 && unclosedBrackets == 0) {
            allValidParentheses.add(currentCombination);
            return;
        }

        // Add an opening bracket if we still have some available
        if (remainingOpenBrackets > 0) {
            generateValidCombinations(remainingOpenBrackets - 1, unclosedBrackets + 1, currentCombination + "(");
        }

        // Add a closing bracket if there are unclosed opening brackets
        if (unclosedBrackets > 0) {
            generateValidCombinations(remainingOpenBrackets, unclosedBrackets - 1, currentCombination + ")");
        }
    }
}
