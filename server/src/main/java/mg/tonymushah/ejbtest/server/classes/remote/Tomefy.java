package mg.tonymushah.ejbtest.server.classes.remote;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import jakarta.ejb.Stateful;
import mg.tonymushah.ejbtest.server.interfaces.remote.PeopleWithMemory;

@Stateful
public class Tomefy implements PeopleWithMemory {

    private HashMap<Date, String> memory;

    public Tomefy(){
        this.memory = new HashMap<Date, String>();
    }
    @Override
    public String sayHello() {
        // TODO Auto-generated method stub
        return "Ta gueule";
    }

    @Override
    public String think() {
        // TODO Auto-generated method stub
        return "I hope that you won't get any girlfriend this year";
    }

    @Override
    public void send(String speech) {
        // TODO Auto-generated method stub
        this.memory.put(new Date(), speech);
    }

    @Override
    public Map<Date, String> getMemory() {
        // TODO Auto-generated method stub
        return this.memory;
    }
    
}
