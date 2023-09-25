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
}
