package sk.upjs.paz;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Fibonacci {

    public static long pomocnepole [];
    public static long fibonaccirekurzivne(int n) {
        if (n==0){
            return 0;
        }
        if (n==1){
            return 1;
        }
        return fibonaccirekurzivne(n-1)+fibonaccirekurzivne(n-2);
    }

    public static long fiboaciSpustac(int n){
        pomocnepole = new long[n+1];
        Arrays.fill(pomocnepole,-1);
        pomocnepole[0]=0;
        pomocnepole[1]=1;

        //return fibonaciMemoizacia(n);
        return fibonacciDynam(n);
    }

    private static long fibonaciMemoizacia(int n){

        if (pomocnepole[n] != -1){
            return pomocnepole[n];
        }else {
            pomocnepole [n] = fibonaciMemoizacia(n-1)+fibonaciMemoizacia(n-2);
        }
        return pomocnepole[n];
    }

    public static long fibonacciDynam(int n){

        for (int i = 2; i < pomocnepole.length ; i++) {
            pomocnepole[i] = pomocnepole[i-1] + pomocnepole[i-2];
        }
        return pomocnepole[n];
    }





    public static void main(String[] args) {
        long f = fibonaccirekurzivne(10);
        System.out.println(f);
        System.out.println(fiboaciSpustac(100));
    }
}
