package mg.tonymushah.ejbtest.server.classes.remote;

import jakarta.ejb.Stateless;
import mg.tonymushah.ejbtest.server.interfaces.remote.People;

@Stateless
public class Tony implements People {
    @Override
    public String sayHello() {
        // TODO Auto-generated method stub
        return "Hello world!";
    }
}
