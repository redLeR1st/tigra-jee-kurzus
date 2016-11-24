package hu.tigra.jee.data;

import hu.tigra.jee.model.Allocation;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import java.util.List;

/**
 * Created by h644771 on 2016. 10. 06..
 */
@RequestScoped
public class AllocationListProducer {

    @Inject
    private AllocationRepository allocationRepository;

    private List<Allocation> allocations;

    private List<Allocation> targyaloTerem;
    private List<Allocation> eloadoTerem;
    private List<Allocation> zeneTerem;




    @Produces
    @Named
    public List<Allocation> getAllocations() {
        return allocations;
    }
    public void onAllocationListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final Allocation allocation) {
        retrieveAllMembersOrderedByEmail();
    }

    @PostConstruct
    public void retrieveAllMembersOrderedByEmail() {
        allocations = allocationRepository.findAllOrderedByEmail();
    }
/***************************************************************/

@Produces
@Named
public List<Allocation> getTargyaloTeremList() {
    targyaloTerem = allocationRepository.findTargyaloTerem();
    return targyaloTerem;
}

    @Produces
    @Named
    public List<Allocation> getEloadoTeremList() {
        eloadoTerem = allocationRepository.findEloadoTerem();
        return eloadoTerem;
    }

    @Produces
    @Named
    public List<Allocation> getZeneTeremList() {
        zeneTerem = allocationRepository.findZenteTerem();
        return zeneTerem;
    }



}
