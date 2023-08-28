package com.company.array;

public class Candy {
    public int candy(int[] ratings) {
        int curAmount=1;
        int totalAmount=1;
        int [] amount=new int[ratings.length];
        amount[0]=1;
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]==ratings[i-1]){
                curAmount=1;
            }else if(ratings[i]>ratings[i-1]){
                curAmount+=1;
            }else if(ratings[i]<ratings[i-1]){
                if(curAmount==1){
                    int j=i;
                    amount[j]=1;
                    while(j>0 && ratings[j]<ratings[j-1] && amount[j]==amount[j-1]){
                        totalAmount+=1;
                        amount[j-1]+=1;
                        j--;
                    }
                }else{
                    curAmount=1;
                }
            }
            totalAmount+=curAmount;
            amount[i]=curAmount;
        }
        return totalAmount;
    }
}
