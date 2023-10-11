package mg.tonymushah.ejbtest.server.classes.remote;

import java.util.List;
import java.util.UUID;

import jakarta.ejb.Stateful;
import jakarta.inject.Inject;
import mg.tonymushah.ejbtest.server.classes.entities.TPeople;
import mg.tonymushah.ejbtest.server.classes.inputs.Pagination;
import mg.tonymushah.ejbtest.server.classes.services.PeopleService;
import mg.tonymushah.ejbtest.server.interfaces.remote.PeopleRepository;

@Stateful
public class PeopleQuery implements PeopleRepository {
    
    @Inject
    PeopleService service;

    @Override
    public void save(TPeople input) {
        service.save(input);
    }

    @Override
    public TPeople getByID(UUID id) {
        return service.getByID(id);
    }

    @Override
    public void delete(TPeople input) {
        // TODO Auto-generated method stub
        service.delete(input);
    }

    @Override
    public List<TPeople> get(Pagination pagination) {
        return service.get(pagination);
    }
    
}
