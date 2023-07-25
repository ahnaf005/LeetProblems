package com.company.array;

public class MountainPeak {
    public int peakIndexInMountainArray(int[] arr) {
        int left=0;
        int right=arr.length-1;
        int middle= left+(right-left)/2;
        while(middle>0 && middle<arr.length-1){
            if(arr[middle]>arr[middle-1] && arr[middle]>arr[middle+1]){
                break;
            }
            if(arr[middle]<arr[middle-1] && arr[middle-1]>arr[middle+1]){
                right=middle;
            }else{
                left=middle;
            }
            middle= left+(right-left)/2;
        }
        return middle;
    }
}
