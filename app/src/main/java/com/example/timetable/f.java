package com.example.timetable;

public class f {
    public static void main(String[] args) {
        int x=10;
        String word = Integer.toBinaryString(x);
        int max=0;
        int temp=0;
        for (int i = 0; i < word.length(); i++) {
            if(word.charAt(i)=='1')
                max++;
            else if(word.charAt(i)=='0'){
                if(max>temp)
                temp=max;
                max=0;
            }
        }
        System.out.println("the answ is "+temp);
    }
}
