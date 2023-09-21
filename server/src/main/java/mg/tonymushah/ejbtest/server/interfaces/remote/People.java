package mg.tonymushah.ejbtest.server.interfaces.remote;

import jakarta.ejb.Remote;

@Remote
public interface People {
    String sayHello();
}
