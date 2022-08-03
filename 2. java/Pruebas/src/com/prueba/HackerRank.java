package com.prueba;

public class HackerRank {
    public static void main(String[] args) {

        int n = 2;
        if (n%2==0 && n < 20){
            System.out.println("Weird");
        } else if (n>2) {
            System.out.println("Not Weird");
        } else if (n > 6) {
            System.out.println("Weird");
        }else if(n > 20){
            System.out.println("Not Weird");
        }

        System.out.println(3%2);
    }

}
