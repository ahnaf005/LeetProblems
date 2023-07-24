package com.company.math;

public class PowXN {
    public double myPow(double x, int n) {
        long val=n;
        if(n<0){
            val=-val;
            x=1/x;
        }
        return pow(x,val);
    }

    public double pow(double x, long n) {
        if(n==0)
            return 1;
        if(n%2 ==0)
            return pow(x*x,n/2);
        return x*pow(x,n-1);
    }
}
