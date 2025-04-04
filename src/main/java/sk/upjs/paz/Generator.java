package sk.upjs.paz;

import java.util.Arrays;
/**
 * Trieda Generator generujúca k-prvkové variácie s opakovaním z prvkov množiny {1, 2, 3}, t.j. postupnosti dĺžky k z čísel {1, 2, 3}.
 */
public class Generator {
        /**
         * Pole, v ktorom generujeme postupnost
         */
        private int[] pole;
        private int []cisla;

        /**
         * Spracuje hodnoty v postupnosti - vypise ich
         */
        private void vypis() {

                for (int i = 0; i < pole.length; i++) {
                        System.out.print(cisla[pole[i]]+ " ");
                }
                System.out.println( );
        }

        /**
         * Generuje variacie s opakovanim v podpoli pocnuc indexom odIndexu
         */
        private void generuj(int odIndexu) {



        }

        /**
         * Nastartuje generovanie
         */
        public void generuj() {
                generuj(0);
        }

        public Generator(int k,int [] cisla) {
                pole = new int[k];
                this.cisla =cisla;
        }

        public static void main(String[] args) {
                int [] cisla = {23,40,55,90};
                Generator g = new Generator(3,cisla);
                g.generuj();
        }

        public Generator(Object [] o ,Object [] a) {

        }
}
