package com.company.string;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String>res=new ArrayList<>();
        List<String >curLine=new ArrayList<>();
        int curLen=0;
        int curWords=0;
        for (String curWord : words) {
            if (curLen + curWord.length() > maxWidth) {
                String lastCurWord = curLine.get(curWords - 1).trim();
                curLine.set(curWords - 1, lastCurWord);
                int extraSpaces = maxWidth - curLen + 1;
                int extraSpaceLen = 0;
                if (curWords == 1) {
                    extraSpaceLen = extraSpaces;
                    StringBuilder sb = new StringBuilder(lastCurWord);
                    sb.append(" ".repeat(Math.max(0, extraSpaceLen)));
                    curLine.set(0, sb.toString());
                } else {
                    extraSpaceLen = extraSpaces / (curWords - 1);
                    int extraSpaceWords = extraSpaces % (curWords - 1);
                    for (int j = 0; j < curWords - 1; j++) {
                        StringBuilder sb = new StringBuilder(curLine.get(j));
                        if (j < extraSpaceWords) {
                            sb.append(" ".repeat(Math.max(0, extraSpaceLen + 1)));
                        } else {
                            sb.append(" ".repeat(Math.max(0, extraSpaceLen)));
                        }
                        curLine.set(j,sb.toString());
                    }
                }
                res.add(String.join("", curLine));
                curLine.clear();
                curLine.add(curWord.concat(" "));
                curLen = curWord.length() + 1;
                curWords = 1;
            } else {
                curLine.add(curWord.concat(" "));
                curLen += curWord.length() + 1;
                curWords++;
            }
        }
        curLine=curLine.stream().map(String::trim).collect(Collectors.toList());
        String lastLine=String.join(" ",curLine);
        StringBuilder sb=new StringBuilder(lastLine);
        sb.append(" ".repeat(Math.max(0, maxWidth-lastLine.length())));
        res.add(sb.toString());
        return res;
    }
}
