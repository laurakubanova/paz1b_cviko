package sk.upjs.paz;

import java.io.*;
import java.util.*;

/**
 * Riešenie problému plnenia batoha jednoduchým prístupom založeným na generovaní všetkých 0-1 postupností dĺžky n, kde n je počet predmetov.
 */
public class Trezor {

        /**
         * Trieda uchovavajuca udaje o jednom predmete
         */
        public static class Predmet {
                int cena;
                int velkost;
        }

        /**
         * Zoznam predmetov v trezore
         */
        List<Predmet> predmety;

        /**
         * Najlepsi najdeny vyber
         */
        private int[] najVyber;
        /**
         * Cena najlepsieho najdeneho vyberu
         */
        private int najCena;

        /**
         * Kapacita batohu
         */
        private int kapacitaBatoha;

        /**
         * Pole, v ktorom generujeme 0 a 1 - vsetky moznosti vyberu
         */
        private int[] vyber;

        /**
         * Spracuje vyber
         */
        private void spracuj() {
                // Pre aktualny vyber spocitame celkovu velkost a celkovu cenu vyberu
                int celkovaVelkost = 0;
                int celkovaCena = 0;
                for (int i = 0; i < vyber.length; i++) {
                        if (vyber[i] == 1) {
                                celkovaVelkost += predmety.get(i).velkost;
                                celkovaCena += predmety.get(i).cena;
                        }
                }

                // Overime, ci sa vyber zmesti do batoha
                if (celkovaVelkost > kapacitaBatoha)
                        return;

                // Ak je aktualny vyber ako najlepsi, co sme doposial mali, tak si ho
                // ulozime
                if (celkovaCena > najCena) {
                        najCena = celkovaCena;
                        najVyber = vyber.clone();
                }

        }

        /**
         * Generuje vsetky mozne vybery pocnuc odIdx-tym predmetom
         */
        private void generuj(int odIdx) {
                if (vyber.length == odIdx) {
                        spracuj();
                        return;
                }

                vyber[odIdx] = 0;
                generuj(odIdx + 1);

                vyber[odIdx] = 1;
                generuj(odIdx + 1);
        }

        public List<Predmet> najlepsiVyber(int kapacita) {
                // Inicializujeme hladanie najlepsieho vyberu
                najCena = 0;
                kapacitaBatoha = kapacita;
                // Vytvorime pole, do ktoreho budeme generovat vysledok
                vyber = new int[predmety.size()];
                // Spustime generovanie
                generuj(0);

                // Vyberieme zoznam predmetov v najlepsom najdenom vybere
                List<Predmet> vysledok = new ArrayList<Predmet>();
                for (int i = 0; i < predmety.size(); i++)
                        if (najVyber[i] == 1)
                                vysledok.add(predmety.get(i));

                return vysledok;
        }

        /**
         * Nacita zoznam predmetov z textoveho suboru
         */
        public void nacitajPredmety(File subor) {
                Scanner citac = null;
                try {
                        citac = new Scanner(subor);
                        predmety = new ArrayList<Predmet>();
                        while (citac.hasNextInt()) {
                                Predmet predmet = new Predmet();
                                predmet.cena = citac.nextInt();
                                predmet.velkost = citac.nextInt();
                                predmety.add(predmet);
                        }
                } catch (Exception e) {
                        System.err.println("Zlyhalo nacitanie suboru " + subor);
                } finally {
                        if (citac != null)
                                citac.close();
                }
        }

        public static void main(String[] args) {
                Trezor trezor = new Trezor();
                trezor.nacitajPredmety(new File("trezor.txt"));
                List<Predmet> vyber = trezor.najlepsiVyber(4);

                // Vypiseme vybrane predmety
                for (Predmet predmet : vyber)
                        System.out.println(predmet.cena + "[" + predmet.velkost + "]");
        }
}

