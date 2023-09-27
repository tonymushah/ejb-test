package mg.tonymushah.ejbtest.server.interfaces.remote;

import java.util.Date;
import java.util.Map;

import jakarta.ejb.Remote;

@Remote
public interface HasMemory {
    Map<Date, String> getMemory();
}
