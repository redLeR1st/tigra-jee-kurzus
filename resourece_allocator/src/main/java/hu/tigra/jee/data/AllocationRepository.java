package hu.tigra.jee.data;

import com.sun.prism.shader.AlphaOne_Color_Loader;
import hu.tigra.jee.model.Allocation;
import hu.tigra.jee.model.Member;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;

/**
 * Created by h644771 on 2016. 10. 06..
 */
@ApplicationScoped
public class AllocationRepository {
    @Inject
    private EntityManager em;

    public Allocation findById(Long id) {
        return em.find(Allocation.class, id);
    }

    public Allocation findByStart(Date date) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Allocation> criteria = cb.createQuery((Allocation.class));
        Root<Allocation> allocation = criteria.from(Allocation.class);

        criteria.select(allocation).where(cb.equal(allocation.get("start"), date));
        return em.createQuery(criteria).getSingleResult();

    }

    public Allocation findByEnd(Date date) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Allocation> criteria = cb.createQuery((Allocation.class));
        Root<Allocation> allocation = criteria.from(Allocation.class);

        criteria.select(allocation).where(cb.equal(allocation.get("end"), date));
        return em.createQuery(criteria).getSingleResult();


    }
        public List<Allocation> findAllOrderedByEmail() {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Allocation> criteria = cb.createQuery(Allocation.class);
            Root<Allocation> allocation = criteria.from(Allocation.class);


            criteria.select(allocation).orderBy(cb.asc(allocation.get("email")));
            return em.createQuery(criteria).getResultList();
        }
}
