package ressources;

import db.FakeDatabase;
import model.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("user")
public class UserRessource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers(){
        return FakeDatabase.getUsers();
    }

}
