package com.company.google;

import java.util.HashMap;
import java.util.Map;

public class findAndReplace {
    public String findReplaceString(String s, int[] indices,
                                    String[] sources, String[] targets) {

        StringBuilder result = new StringBuilder();

        int i = 0;

        while (i < s.length()) {

            boolean replaced = false;

            for (int j = 0; j < indices.length; j++) {
                if (indices[j] == i &&
                        s.startsWith(sources[j], i)) {

                    result.append(targets[j]);
                    i += sources[j].length();
                    replaced = true;
                    break;
                }
            }

            if (!replaced) {
                result.append(s.charAt(i));
                i++;
            }
        }

        return result.toString();
    }
}
