package db;

import helper.UserExistingChecker;
import model.Message;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class FakeDatabase {

    private static List<User> users = new ArrayList<>();
    private static List<Message> messages = new ArrayList<>();

    public static List<Message> getMessages(){
        return messages;
    }

    public static List<User> getUsers(){
        return users;
    }

    public static void addMessage(Message message){
        messages.add(message);

        User user = message.getUser();
        if(!UserExistingChecker.existUser(users, user)){
            users.add(user);
        }
    }

}
