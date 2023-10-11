package mg.tonymushah.ejbtest.server.interfaces.remote;

import java.util.List;
import java.util.UUID;

import jakarta.ejb.Remote;
import mg.tonymushah.ejbtest.server.classes.entities.TPeople;
import mg.tonymushah.ejbtest.server.classes.inputs.Pagination;

@Remote
public interface PeopleRepository {
    void save(TPeople input);
    TPeople getByID(UUID id);
    void delete(TPeople input);
    List<TPeople> get(Pagination pagination);
}
