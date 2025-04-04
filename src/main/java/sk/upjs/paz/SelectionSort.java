package sk.upjs.paz;

public class SelectionSort extends TriediaciAlgoritmus {
    @Override
    protected void utried(int dlzkaPola) {
        for (int i = 0; i < dlzkaPola - 1; i++) {
            int minIdx = i;

            for (int j = i + 1; j < dlzkaPola; j++) {
                if (porovnaj(j, minIdx) < 0) {
                    minIdx = j;
                    //keby robime vymen v cykle tak by sme mali viac vymen
                }
            }
            //robim pushik
            //robim pushik 2
            vymen(i, minIdx);
            vypisPole();
        }
    }
}
