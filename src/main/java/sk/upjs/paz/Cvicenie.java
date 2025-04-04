package sk.upjs.paz;

import java.lang.reflect.Array;

public class Cvicenie {


    public static boolean jeUsporiadane(int[] p) {
        int porovany = p[0];
        for (int i=0; i< p.length-1;i++){
            if (p[i]<p[i+1]) {
                return false;
            }
        }
        return true;
    }

    public static int binarneHladajIndex(int[] p, int hodnota) {

        int odIdx = 0;
        int poIdx = p.length-1;

        while (odIdx<=poIdx){
          //z gitlabu
        }
        return -1;
    }




}
