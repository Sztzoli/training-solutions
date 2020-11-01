
package stringtype.registration;
public class UserValidator {
    public boolean isValidUsername(String username) {
        return !(username.isEmpty());
    }
    public boolean isValidPassword(String password1,String password2) {
        return password1.equals(password2) && password1.length()>=8;
    }
    public boolean isValidEmail(String email){
        return email.indexOf("@")>1 && email.indexOf("@")<email.indexOf(".") && email.indexOf(".")!=email.length()-1;
    }

    public String isCorrect(boolean a){
        return a? "helyes" : "helytelen";
}
}