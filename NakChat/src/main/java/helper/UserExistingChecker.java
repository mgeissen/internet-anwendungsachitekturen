package helper;

import model.User;

import java.util.List;

public class UserExistingChecker {

    public static boolean existUser(List<User> userList, User currentUser){
        for (User user :
                userList) {
            if (currentUser.getUsername().equals(user.getUsername())){
                return true;
            }
        }
        return false;
    }

}
