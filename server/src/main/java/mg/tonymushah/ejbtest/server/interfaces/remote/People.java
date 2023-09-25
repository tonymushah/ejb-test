package mg.tonymushah.ejbtest.server.interfaces.remote;

import jakarta.ejb.Remote;

@Remote
public interface People {
    String sayHello();
    default int calculate(int x, int y){
        return 0;
    }
    String think();
}
