package controlselection.accent;

public class WithoutAccents {
    public static final String ACCENT="áéíóőúűÁÉÍÓŐÚŰ";
    public static final String WHITOUT_ACCENT="aeioőuüAEIOÖUÜ";

    public char withoutAccents(char c) {
        char newChar;
        if (ACCENT.contains(Character.toString(c))){
            newChar=WHITOUT_ACCENT.charAt(ACCENT.indexOf(c));
    }
        else {
            newChar=c;
        }
    return newChar;
    }


}
