package sk.upjs.paz;

import java.util.ArrayList;
import java.util.List;

public class Zahradka {

    int[][] uroda;
    int[][] maxPocet;

    public Zahradka(int[][] uroda) {
        this.uroda = uroda;
        maxPocet = new int[uroda.length][uroda[0].length];
    }

    public int najdiMax() {
        //vyplnim policko [0,0]
        //vyplnim prvy riadok a prvy stlpec
        //vypocitam zvysok tablku a vratim vysledok na poslednom policku
        int riadok = uroda.length;
        int stlpec = uroda[0].length;
        maxPocet[0][0] = uroda[0][0];
        for (int i = 1; i < riadok; i++) {
            maxPocet[i][0] = maxPocet[i-1][0]+uroda[i][0];
            //toto vyplni nulty stlpec
        }

        for (int i = 1; i < stlpec; i++) {
            maxPocet[0][i] = maxPocet[0][i-1]+uroda[0][i];
        }

        for (int i = 1; i < riadok; i++) {
            for (int j = 1; j < stlpec; j++) {
                int maximum = Math.max(maxPocet[i][j - 1], maxPocet[i - 1][j]);
                maxPocet[i][j] = uroda[i][j] + maximum;
            }
        }

        return maxPocet[riadok - 1][stlpec - 1];

    }

    public List<String> zrekonstruuj(){
        List<String>cesta = new ArrayList<>();
        int riadok = 0;
        int stlpec = 0;

        return cesta;
    }

    //Daná je postupnosť N čísel: P[0], P[1], ..., P[N-1].
    // Nájdite takú podpostupnosť (nemusí byť súvislá),
    // aby všetky hodnoty vybranej podpostupnosti tvorili rastúcu postupnosť hodnôt a vybraná postupnosť bola najdlhšia možná.





    public static void main(String[] args) {
        int[][] uroda = {
                {3,10,5,2},
                {8,7,3,1},
                {4,6,9,5}};
        Zahradka z = new Zahradka(uroda);
        System.out.println(z.najdiMax());
    }


}
