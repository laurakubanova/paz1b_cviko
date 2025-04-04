package sk.upjs.paz;

public class Zlozitost {

    // Celkovy pocet zrealizovanych operacii
    public static int pocet = 0;

    // Elementarna operacia
    public static void operacia() {
        pocet++;
    }

    // Linearny pocet operacii v zavislosti od n
    public static void linearna(int n) {
        for (int i = 0; i < n; i++)
            operacia();
    }

    // n.log(n) pocet operacii v zavislosti od n
    public static void nlogn(int n) {
        for (int i = 0; i < n; i++)
            for (int j = 1; j < n; j = j * 2)
                operacia();
    }


    public static void logn(int n) {
            for (int j = 1; j < n; j = j * 2) {
                operacia();
            }
            //vrchny czklus bezi nkrat ak ho odstranime tak dostaneme logn nie nlogn
            //j=1,2,4,8,16
            //
    }


    // Kvadraticky pocet operacii v zavislosti od n
    public static void kvadraticka(int n) {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                operacia();
    }

    // Exponencialny pocet operacii v zavislosti od n
    public static void exponencialna(int n) {
        if (n <= 1) {
            operacia();
            return;
        }

        // 2^n = 2*2^(n-1)
        exponencialna(n - 1);
        exponencialna(n - 1);
    }

    public static void main(String[] args) {
        System.out.println("Zaciatok...");
        long zaciatok = System.nanoTime();

        //exponencialna(35);
        //linearna(Integer.MAX_VALUE);
        //exponencialna(31);
        //kvadraticka(290000);
        nlogn(200_000_000);
        long koniec = System.nanoTime();
        System.out.println("Cas behu: " + ((koniec - zaciatok) / 1000000)
                + " milisekund");


    }
}