package mg.tonymushah.ejbtest.server.classes.services;

import java.util.List;
import java.util.UUID;

import jakarta.enterprise.inject.Model;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import mg.tonymushah.ejbtest.server.classes.entities.TPeople;
import mg.tonymushah.ejbtest.server.classes.inputs.Pagination;

@Model
public class PeopleService {
    @PersistenceContext
    EntityManager em;
    @Transactional
    public void save(TPeople input) {
        em.persist(input);
    }

    public TPeople getByID(UUID id) {
        return em.find(TPeople.class, id);
    }

    @Transactional
    public void delete(TPeople input) {
        // TODO Auto-generated method stub
        em.remove(input);
    }

    public List<TPeople> get(Pagination pagination) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<TPeople> query = builder.createQuery(TPeople.class);
        Root<TPeople> root = query.from(TPeople.class);
        query.select(root);
        TypedQuery<TPeople> res = em.createQuery(query);
        return pagination.set(res).getResultList();
    }
}
