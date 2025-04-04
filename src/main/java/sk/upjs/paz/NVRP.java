package sk.upjs.paz;

import java.util.Arrays;

public class NVRP {

    private int[] cisla;
    private int[] dlzky;


    public NVRP(int [] cisla){
        this.cisla=cisla;
        dlzky = new int[cisla.length];
        Arrays.fill(dlzky,1);

    }

    public int dlzka_NVRP(){
        //prechadzam cislami
        //aktualne cislo porovnavam s kazdym predchadyajucim
        //ak je cislo mensie ako aktualne cislo skusim predlzit podposupnost
        //ak mi vznikne dlhsia podpostupnost ulozim si
        //prejdem vyplnenym polom dlzky a vyberiem maximalne hodnoty
        //vratim maximalnu hodnotu
        int maximum = 1;

        for (int i = 1; i < cisla.length; i++) {
            for (int j = i-1; j>=0 ;j--){
                if (cisla[j]<cisla[i]){
                    dlzky[i]=Math.max(dlzky[j]+1,dlzky[i]);
                }
            }
        }

        for (int i =0; i< dlzky.length; i++){
          if (dlzky[i]>maximum){
              maximum=dlzky[i];
          }
        }

        return maximum;
    }


    public static void main(String[] args) {
        int[]cisla = {1,3,5,2,4,8,9,7,10,2};
        NVRP n = new NVRP(cisla);
        System.out.println(n.dlzka_NVRP());
    }
}
