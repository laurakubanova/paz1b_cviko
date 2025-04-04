package sk.upjs.paz;

import java.util.Arrays;

public class NepriatelskeCisla {
    private int[] vstup;
    private boolean[]pouzite;
    private int[] vystup;
    private int pocitadlo=0;

    public NepriatelskeCisla(int[] vstup){
        this.vstup=vstup;
        vystup = new int[vstup.length];
        pouzite = new boolean[vstup.length];

        generuj(0);
        System.out.println(pocitadlo);

    }

    private void generuj(int odIdx){
        if (odIdx==vystup.length){
            //spracuj();
            pocitadlo++;
            System.out.println(Arrays.toString(vystup));
            return;
        }

        for (int i = 0; i < vstup.length; i++) {
            //chcem skontrolovat delitelnost vystup[odIdx-1] a vstup[i]
            if (!pouzite[i]){
                if (odIdx==0||suPriatelske(vystup[odIdx-1],vstup[i])){
                    vystup[odIdx]=vstup[i];
                    pouzite[i]=true;
                    generuj(odIdx+1);
                    pouzite[i]=false;
                }
            }
        }
    }

    private boolean suPriatelske(int a, int b){
        if (a%b==0||b%a==0){
            return false;
        }
        return true;
    }

//    private void spracuj(){
//
//        for (int i = 0; i < vystup.length-1; i++) {
//            if (vystup[i]%vystup[i+1]==0||vystup[i+1]%vystup[i]==0){
//                return;
//            }
//        }
//        pocitadlo++;
//        System.out.println(Arrays.toString(vystup));
//    }

    public static void main(String[] args) {
        int [] vstup = {3,5,4,8};
        NepriatelskeCisla nc =new NepriatelskeCisla(vstup);
    }


}
