package stringconcat.stringconcat;

public class Name {
    private Title title;
    private String familyName;
    private String middleName;
    private String givenName;

    public Name(String familyName, String middleName, String givenName, Title title) {
        this(familyName, middleName, givenName);
        this.title=title;
    }

    public Name(String familyName, String middleName, String givenName) {
        if (!isEmpty(familyName) || !isEmpty(givenName)){
            throw new IllegalArgumentException("üres a név");
        }
        this.familyName=familyName;
        this.middleName=middleName;
        this.givenName=givenName;
    }

    public String concatNameWesternStyle() {
        String s="";
        if (title != null) {
            s = s.concat(title.getTitle());
        }
        s=s.concat(givenName);
        s=s.concat(" ");
        if (!middleName.isEmpty()){
            s=s.concat(middleName);
            s=s.concat(" ");
        }
        s=s.concat(familyName);
        return s;
    }

    public String concatNameHungarianStyle() {
       String s="";
       if (title != null) {
           s+=title.getTitle();
       }
        s+=familyName;
       s+=" ";
       if (!middleName.isEmpty()) {
           s+=givenName;
           s+=" ";
       }

        s+=middleName;
        return s;
    }

    private boolean isEmpty(String name) {
        boolean a = false;
        if (name!=null && !name.isEmpty()){
            a=true;
        }
        return a;
    }


}
