package model;

import javax.ws.rs.Produces;

public class Message {

    private User user;
    private String message;

    public Message() {

    }

    public User getUser() {
        return user;
    }

    public String getMessage() {
        return message;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
