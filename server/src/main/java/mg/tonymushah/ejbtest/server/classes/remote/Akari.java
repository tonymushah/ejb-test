package mg.tonymushah.ejbtest.server.classes.remote;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import jakarta.ejb.Stateful;
import mg.tonymushah.ejbtest.server.interfaces.remote.HasMemory;
import mg.tonymushah.ejbtest.server.interfaces.remote.People;

@Stateful
public class Akari implements People, HasMemory {

    private HashMap<Date, String> memory;

    @Override
    public Map<Date, String> getMemory() {
        // TODO Auto-generated method stub
        return memory;
    }

    @Override
    public String sayHello() {
        // TODO Auto-generated method stub
        return "Unimplemented method 'sayHello'";
    }

    @Override
    public String think() {
        // TODO Auto-generated method stub
        return ("Unimplemented method 'think'");
    }

    @Override
    public void send(String speech) {
        // TODO Auto-generated method stub
        this.memory.put(new Date(), speech);
    }
    
}
