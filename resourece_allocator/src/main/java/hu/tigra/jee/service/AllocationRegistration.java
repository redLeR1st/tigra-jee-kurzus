package hu.tigra.jee.service;

import hu.tigra.jee.model.Allocation;
import hu.tigra.jee.model.Member;
import sun.rmi.runtime.Log;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.logging.Logger;

/**
 * Created by h644771 on 2016. 10. 06..
 */

@Stateless
public class AllocationRegistration {

    @Inject
    private Logger log;

    @Inject
    private EntityManager em;

    @Inject
    private Event<Allocation> allocationEventSrc;

    public void register(Allocation allocation) throws Exception {
        log.info("Allocation ends: " + allocation.getEnd());
        em.persist(allocation);
        allocationEventSrc.fire(allocation);
    }

    public Allocation find(Long id) throws Exception{
        log.info("Findong allocation woth ID = " + id);
        return em.find(Allocation.class, id);
    }
}
