package sk.upjs.paz;

import java.util.*;

public class Osoba {
    /**
     * Meno osoby
     */
    private String meno;
    /**
     * Zoznam deti osoby
     */
    private List<Osoba> deti = new ArrayList<Osoba>();

    /**
     * Konstruktor osoby v strome potomkov
     *
     * @param meno meno osoby
     */
    public Osoba(String meno) {
        this.meno = meno;
    }

    /**
     * Prida osobe dieta
     *
     * @param dieta referencia na pridavane dieta
     */
    public void pridajDieta(Osoba dieta) {
        deti.add(dieta);
    }

    /**
     * Vrati celkovy pocet potomkov osoby
     */
    public int pocetPotomkov() {
        int pocetPotomkovDeti = 0;
        for (Osoba dieta : deti)
            pocetPotomkovDeti += dieta.pocetPotomkov();

        return pocetPotomkovDeti + deti.size();
    }

    /**
     * Vypise rodostrom osoby
     */
    public void vypisRodostrom() {
        System.out.println(meno);
        for (Osoba dieta : deti)
            dieta.vypisRodostrom();
    }

    /**
     * Main s vytvorenim stromu potomkov pre Janka
     */
    public static void main(String[] args) {
        Osoba janko = new Osoba("Janko");
        Osoba jozko = new Osoba("Jozko");
        Osoba maria = new Osoba("Maria");
        Osoba karol = new Osoba("Karol");
        Osoba lucia = new Osoba("Lucia");
        Osoba petra = new Osoba("Petra");
        janko.pridajDieta(jozko);
        janko.pridajDieta(maria);
        janko.pridajDieta(karol);
        karol.pridajDieta(lucia);
        karol.pridajDieta(petra);
        janko.vypisRodostrom();
        System.out.println("=======");
        System.out.println(janko.pocetGeneracii());
        List<Osoba> zoznam = new ArrayList<>();
        janko.pridajDoZoznamu(zoznam);
        System.out.println(zoznam.toString());
    }

    public int pocetGeneracii() {

        if (pocetPotomkov() == 0) {
            return 0;
        }
        //obe mozu byt baza

//        if (deti.isEmpty()){
//            return 0;
//        }

        int max = 0;

        for (Osoba dieta : deti) {
            max = Math.max(dieta.pocetGeneracii(), max);

        }
        //za svoj zoznam deti pripocitam jednotku
        return max + 1;
    }

    public void pridajDoZoznamu(List<Osoba> zoznam){

//        if (pocetPotomkov() == 0) {
//            return;
//        }
        //NEFUNGUJE


        zoznam.add(this);

        for (Osoba dieta : deti) {
            dieta.pridajDoZoznamu(zoznam);
        }
        //preORDER

    }


    @Override
    public String toString() {
        return meno;
    }

}
