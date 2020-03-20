//package com.bentleyxia.Easy;

public class BiSearch {
    public static void main(String[] args) {
        int[] array = new int[]{1,1,2,7,8,9,10};
        int t = 10, b = 0, e = 7, m=0;

        while(b != e){
            m = (b + e) / 2;
            if(array[m] < t){
                b = m + 1 ;
            }
            if (array[m] > t) {
                e = m;
            }
            if (array[m] == t) {
                System.out.println("yes");
                break;
            }
        }
        System.out.println(b);//if you want less array[b-1]
    }
}