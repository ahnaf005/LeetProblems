package com.company;

public class Main {
    public static int oddOrPos(int[] x) {
        int count = 0;
        for (int i = 0; i < x.length; i++) {
            System.out.println(x[i] % 2);
            if (x[i] % 2 != 0 || x[i] > 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
	// write your code here
        int []x = new int []{-3, -2, 0, 1, 4};
        System.out.println(oddOrPos(x));
        System.out.println("repo created");
    }
}
