package com.company.stack;

import java.util.ArrayList;
import java.util.Stack;

public class simplifyPath {
    public String simplifyPath(String path) {
        String[] dirs = path.split("/");
        Stack<String> stack = new Stack<>();
        for(var dir : dirs) {
            if(dir.isEmpty() || dir.equals(".")) {
                continue;
            }
            if(dir.equals("..")) {
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
            else{
                stack.push(dir);
            }
        }
        return "/" + String.join("/", stack);
    }
}
