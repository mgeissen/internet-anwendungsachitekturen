import ressources.MessageRessource;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/nakchat")
public class ChatServer extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        HashSet<Class<?>> classes = new HashSet<>();
        classes.add(MessageRessource.class);
        return classes;
    }

    @Override
    public Set<Object> getSingletons() {
        return super.getSingletons();
    }
}
