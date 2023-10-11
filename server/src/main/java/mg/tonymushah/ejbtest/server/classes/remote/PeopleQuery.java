package mg.tonymushah.ejbtest.server.classes.remote;

import java.util.UUID;
import java.util.stream.Stream;

import jakarta.ejb.Stateful;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import mg.tonymushah.ejbtest.server.classes.entities.TPeople;
import mg.tonymushah.ejbtest.server.classes.inputs.Pagination;
import mg.tonymushah.ejbtest.server.interfaces.remote.PeopleRepository;

@Stateful
public class PeopleQuery implements PeopleRepository {
    
    @PersistenceContext
    EntityManager em;

    @Override
    public void save(TPeople input) {
        this.em.persist(input);
    }

    @Override
    public TPeople getByID(UUID id) {
        return em.find(TPeople.class, id);
    }

    @Override
    public void delete(TPeople input) {
        // TODO Auto-generated method stub
        em.remove(input);
    }

    @Override
    public Stream<TPeople> get(Pagination pagination) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<TPeople> query = builder.createQuery(TPeople.class);
        Root<TPeople> root = query.from(TPeople.class);
        query.select(root);
        TypedQuery<TPeople> res = em.createQuery(query);
        return pagination.set(res).getResultStream();
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
    
}
