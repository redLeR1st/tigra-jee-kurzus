package hu.tigra.jee.controller;

import hu.tigra.jee.model.Allocation;
import hu.tigra.jee.service.AllocationDelete;
import hu.tigra.jee.service.AllocationRegistration;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.enterprise.inject.Produces;
import java.util.concurrent.TimeUnit;


/**
 * Created by h644771 on 2016. 10. 06..
 */

@Model
public class AllocationContorller {

    @Inject
    private FacesContext facesContext;

    @Inject
    private AllocationRegistration allocationRegistration;

    @Inject
    private AllocationDelete allocationDelete;

    @Produces
    @Named
    protected Allocation newAllocation;

    @PostConstruct
    public void initNewAllocation() {
        newAllocation = new Allocation();
    }

    public void registerTargyaloTerem() throws Exception {
        newAllocation.setTeremTipus("targyaloterem");
        register();
    }
    public void registerEloadoTerem() throws Exception {
        newAllocation.setTeremTipus("eloadoterem");
        register();
    }
    public void registerZeneTerem() throws Exception {
        newAllocation.setTeremTipus("zeneterem");
        register();
    }

    public  void register() throws Exception {


        try {

            if(newAllocation.getStart().after(newAllocation.getEnd())){
                throw new Exception("Hiba! A foglalás befejezte nem lehet hamarabb, mint a kezdete!");
            }

            long duration = newAllocation.getEnd().getTime() - newAllocation.getStart().getTime();
            long diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(duration);
            if(diffInMinutes<15){
               // String str = Long.toString(diffInMinutes);

                throw new Exception("Hiba! A foglalás legkissebb időtartama 15 perc");
            }


            allocationRegistration.register(newAllocation);
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Registration successful");
            facesContext.addMessage(null, m);
            initNewAllocation();


        }
        catch (Exception e){
            String errorMessage = getRootErrorMessage(e);
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Registration unsuccessful");
            facesContext.addMessage(null, m);

        }

    }

    public void delete()throws Exception{
        try {
            allocationDelete.delete(newAllocation.getId());
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Allocation deleted!", "Allocation deleted!");
            facesContext.addMessage(null, m);
            initNewAllocation();
        }catch (Exception e){
            String errorMessage = getRootErrorMessage(e);
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Allocation  delete unsuccessful");
            facesContext.addMessage(null, m);
        }
    }

    private String getRootErrorMessage(Exception e) {
        // Default to general error message that registration failed.
        String errorMessage = "Registration failed. See server log for more information";
        if (e == null) {
            // This shouldn't happen, but return the default messages
            return errorMessage;
        }

        // Start with the exception and recurse to find the root cause
        Throwable t = e;
        while (t != null) {
            // Get the message from the Throwable class instance
            errorMessage = t.getLocalizedMessage();
            t = t.getCause();
        }
        // This is the root cause message
        return errorMessage;
    }
}
