package stringbuilder;

public class NameBuilder {


    private boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    public String concatNameHungarianStyle(String familyName, String middleName, String givenName, Title title) {
        if (isEmpty(familyName) || isEmpty(givenName)) {
            throw new IllegalArgumentException("Family name and given name must not be empty!");
        }
        StringBuilder sb = new StringBuilder();
        if (title != null) {
            sb.append(title.getTitle()).append(" ");
        }
        sb.append(familyName).append(" ");
        if (!isEmpty(middleName)) {
            sb.append(middleName).append(" ");
        }
        sb.append(givenName);

        return sb.toString();

    }

    public String concatNameWesternStyle(String familyName, String middleName, String givenName, Title title) {
        if (isEmpty(familyName) || isEmpty(givenName)) {
            throw new IllegalArgumentException("Family name and given name must not be empty!");
        }
        StringBuilder sb = new StringBuilder();
        if (title!=null){
            sb.append(title.getTitle()).append(" ");
        }
        sb.append(givenName).append(" ");
        if (!isEmpty(middleName)){
            sb.append(middleName).append(" ");
        }
        sb.append(familyName);
        return sb.toString();
    }

    public String insertTitle(String name, Title prof, String s) {
        StringBuilder sb = new StringBuilder(name);
        sb.insert(name.indexOf(s)+1, prof.getTitle()+s);
        return sb.toString();
    }

    public String deleteNamePart(String name, String removeString) {
        StringBuilder sb = new StringBuilder(name);
        sb.delete(name.indexOf(removeString),name.indexOf(removeString)+removeString.length());
        return sb.toString();
    }
}
