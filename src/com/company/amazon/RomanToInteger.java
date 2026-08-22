package com.company.amazon;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public int romanToInt(String s) {
        // ✅ Edge case check: if the input string is null or empty, return 0
        if (s == null || s.isEmpty()) {
            return 0;
        }

        // 📝 Step 1: Define Roman numeral to integer mappings
        Map<Character, Integer> values = new HashMap<>();
        values.put('I', 1);
        values.put('V', 5);
        values.put('X', 10);
        values.put('L', 50);
        values.put('C', 100);
        values.put('D', 500);
        values.put('M', 1000);

        // 📝 Step 2: Initialize running total and previous value tracker
        int result = 0;
        int prevValue = 0;

        // 📝 Step 3: Traverse the string from right to left
        // Why right to left?
        // → Because subtraction cases (e.g., IV = 4) are easier to detect:
        //    If a smaller numeral comes before a larger one, we subtract it.
        //    Example: I before V → subtract 1, else add normally.
        for (int i = s.length() - 1; i >= 0; i--) {
            int currentValue = values.get(s.charAt(i));

            /*
             * Rule:
             * - If current value >= previous value, ADD it to result
             *   (e.g., VI → I(1) comes after V(5) → 5+1 = 6)
             * - Else, SUBTRACT it from result
             *   (e.g., IV → I(1) comes before V(5) → 5-1 = 4)
             */
            if (currentValue >= prevValue) {
                result += currentValue;
            } else {
                result -= currentValue;
            }

            // Update prevValue for the next iteration to the left
            prevValue = currentValue;
        }

        // 📝 Step 4: Return the final converted integer
        return result;
    }
}
