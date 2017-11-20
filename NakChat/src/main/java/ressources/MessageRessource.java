package ressources;

import db.FakeDatabase;
import model.Message;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/message")
public class MessageRessource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getMessages(){
        return FakeDatabase.getMessages();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public void saveMessage(Message message){
        FakeDatabase.addMessage(message);
    }


}
