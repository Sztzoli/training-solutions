package week05d03;

import java.util.List;

public class UserValidator {

    public void validate(List<User> users){
        for (User user : users) {
            String userName=user.getName();
            int userAge=user.getAge();
            if (!isValid(userName)) {
                throw new IllegalArgumentException("Invalid argument:"+userName);
            }
            if (!isValid(userAge)){
                throw new IllegalArgumentException("Invalid argument:"+userAge);
            }
        }
    }

    private boolean isValid(String str){
        boolean valid=true;
        if (str==null || str.isBlank()){
            valid=false;
        }
        return valid;
    }

    private boolean isValid(int number){
        boolean valid=true;
        if (number<0 || number>120){
            valid=false;
        }
        return valid;
    }
}
