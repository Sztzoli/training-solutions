package week12d02;

public enum SideType {
    EVEN_SIDE,
    ODD_SIDE;

    static SideType convertToSideType(String str){
        if (str.equals("0")){
            return EVEN_SIDE;
        }
        return ODD_SIDE;
    }


}
