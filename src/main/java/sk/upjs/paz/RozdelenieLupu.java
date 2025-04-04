package sk.upjs.paz;

import java.util.Arrays;

public class RozdelenieLupu {
    private int [] cenyPredmetov;
    //do pola generujem
    private int [] pole;
    private int[] najlepsieRozdelenie;
    private int minimum = Integer.MAX_VALUE;
    private int[] vyber;


    public RozdelenieLupu(int[] cenyPredmetov) {
        this.cenyPredmetov = cenyPredmetov;
        pole = new int[cenyPredmetov.length];
        generuj(0);
        System.out.println("najlepsie rozdelenie " + Arrays.toString(najlepsieRozdelenie));
        System.out.println("lebo rozdiel je min" + minimum);
    }

    public void generuj(){
        generuj(0);
    }


    public void spracuj(){
        int prvy = 0;
        int druhy = 0;

        for (int i = 0; i <pole.length ; i++) {
            if (pole[i]==0){
                prvy += cenyPredmetov[i];
            }
            else{
                druhy += cenyPredmetov[i];
            }
        }
        int rozdiel=0;
        rozdiel = Math.abs(prvy-druhy);
        if (rozdiel<minimum){
            minimum = rozdiel;
            najlepsieRozdelenie = pole.clone();
        }

    }
    //chyba
    private void generuj(int odIndex) {
        if (pole.length==odIndex){
            spracuj();
            return;
        }

        for (int i = 0; i <=1 ; i++) {
            pole[odIndex]=i;
            generuj(odIndex+1);
            //pochopit
        }
    }

    public static void main(String[] args) {
        int [] cenyPredmetov = {100,400,600,7,8,9};
        RozdelenieLupu lup = new RozdelenieLupu(cenyPredmetov);
    }
}
