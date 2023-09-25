package mg.tonymushah.ejbtest.server.classes.remote;

import jakarta.ejb.Remote;
import jakarta.ejb.Stateless;
import mg.tonymushah.ejbtest.server.interfaces.remote.People;

@Stateless
@Remote(People.class)
public class Tony implements People {
    @Override
    public String sayHello() {
        // TODO Auto-generated method stub
        return "Hello world!";
    }
    @Override
    public int calculate(int x, int y) {
        return (x + y) * x;
    }
    @Override
    public String think() {
        return "Expert EJB tsika";
    }
    @Override
    public void send(String speech) {
        // TODO Auto-generated method stub
        
    }
}
