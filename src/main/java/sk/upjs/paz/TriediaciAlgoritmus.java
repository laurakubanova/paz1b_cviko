package sk.upjs.paz;

import java.util.Arrays;

public abstract class TriediaciAlgoritmus {

    /**
     * Aktualne usporiadavane pole
     */
    private int[] p;
    private int pocetVymen = 0;
    private int pocetPorovnani = 0;

    /**
     * Porovna prvky v poli na zadanych indexoch
     *
     * @return vrati zaporne cislo, ak p[idx1] < p[idx2], * 0, ak p[idx1]==p[idx2], a * kladne cislo, ak p[idx1] > p[idx2]
     */
    protected int porovnaj(int idx1, int idx2) {
        pocetPorovnani++;
        return Integer.compare(p[idx1], p[idx2]);

        /*
         * Alternativa:
         * if (p[idx1] < p[idx2]) return -1; * if (p[idx1] > p[idx2]) return 1;
         * return 0;
         */
    }

    /**
     * Vymeni prvky v usporiadavanom poli na zadanych indexoch
     */
    protected void vymen(int idx1, int idx2) {
        pocetVymen++;
        int pom = p[idx1];
        p[idx1] = p[idx2];
        p[idx2] = pom;
    }

    /**
     * Vypise pole
     */
    protected void vypisPole() {
        System.out.println(Arrays.toString(p));
    }

    /**
     * Usporiada prvky v poli od najmensieho po najvacsie
     *
     * @param p
     *            pole, ktoreho prvky maju byt usporiadane
     */
    public void utried(int[] p) {
        this.p = p;
        utried(p.length);
        System.out.println("pocet porovnani :" + pocetPorovnani);
        System.out.println("pocet vymen :" + pocetVymen);
        pocetVymen = 0;
        pocetPorovnani=0;
        this.p = null;

    }

    /**
     * Metoda, ktora implementuje triedenie podla urciteho algoritmu
     * @param dlzkaPola dlzka (pocet prvkov) usporiadavaneho pola
     */
    protected abstract void utried(int dlzkaPola);
}
