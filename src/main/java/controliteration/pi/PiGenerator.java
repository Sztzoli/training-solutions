package controliteration.pi;

public class PiGenerator {

    private static final String PI_POET =
            "Nem a régi s durva közelítés,\n" +
                    "Mi szótól szóig így kijön\n" +
                    "Betűiket számlálva.\n" +
                    "Ludolph eredménye már,\n" +
                    "Ha itt végezzük húsz jegyen.\n" +
                    "De rendre kijő még tíz pontosan,\n" +
                    "Azt is bízvást ígérhetem.\n" +
                    "\t";

    public String PiGenerator() {
        int count = 0;
        String Pi = "";
        for (int i = 0; i < PI_POET.length(); i++) {
            if (Character.isAlphabetic(PI_POET.charAt(i))) {
                count++;
            } else {
                if (count != 0) {
                    if (Pi.length()==1) {
                        Pi += ",";
                    }
                    Pi += count;
                    count = 0;
                }
            }
        }
        return Pi;

    }



}
