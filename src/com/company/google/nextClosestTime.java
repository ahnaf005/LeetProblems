package com.company.google;

import java.util.HashSet;
import java.util.Set;

public class nextClosestTime {
    int HOURS = 24;
    int MINUTES = 60;
    public String nextClosestTime(String time) {
        Set<Integer> nums = new HashSet<>();
        for (int i = 0; i < time.length(); i++) {
            if(i != 2){
                nums.add(Integer.parseInt(time.substring(i, i + 1)));
            }
        }
        String [] timeArr = time.split(":");
        int hours = Integer.parseInt(timeArr[0]);
        int minutes = Integer.parseInt(timeArr[1]);
        for(int i = 0; i < HOURS*MINUTES; i++){
            int[] newTime = addMinute(hours, minutes);
            hours = newTime[0];
            minutes = newTime[1];
            if(isValid(nums,hours,minutes)){
                return timeString(hours,minutes);
            }
        }
        return timeString(hours,minutes);
    }

    private String timeString(int hours, int minutes){
        StringBuilder str = new StringBuilder();
        if(hours < 10){
            str.append("0");
        }
        str.append(hours);
        str.append(":");
        if(minutes < 10){
            str.append("0");
        }
        str.append(minutes);
        return str.toString();
    }

    private boolean isValid(Set<Integer> nums, int hours, int minutes) {
        if(hours < 10 || minutes < 10){
            if(!nums.contains(0)){
                return false;
            }
        }
        if(hours == 0 && minutes == 0){
            return true;
        }
        if(hours != 0){
            int tmp = hours;
            while(tmp!=0){
                if(!nums.contains(tmp%10)){
                    return false;
                }
                tmp = tmp/10;
            }
        }
        if(minutes != 0){
            int tmp = minutes;
            while(tmp!=0){
                if(!nums.contains(tmp%10)){
                    return false;
                }
                tmp = tmp/10;
            }
        }
        return true;
    }

    private int[] addMinute(int hours, int minutes) {
        int newMinutes = minutes + 1;
        int newHours = hours;
        if(newMinutes >= MINUTES){
            newMinutes = newMinutes - 60;
            newHours = newHours + 1;
            if(newHours >= HOURS){
                newHours = newHours - 24;
            }
        }
        return new int[]{newHours, newMinutes};
    }
}
