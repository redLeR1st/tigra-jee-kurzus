package hu.tigra.jee.controller;

import hu.tigra.jee.model.Allocation;
import hu.tigra.jee.service.AllocationRegistration;
import hu.tigra.jee.service.MemberRegistration;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.enterprise.inject.Produces;


/**
 * Created by h644771 on 2016. 10. 06..
 */

@Model
public class AllocationContorller {

    @Inject
    private FacesContext facesContext;

    @Inject
    private AllocationRegistration allocationRegistration;

    @Produces
    @Named
    protected Allocation newAllocation;
    protected Allocation newAllocation1;
    protected Allocation newAllocation2;
    @PostConstruct

    public void initNewAllocation() {
        newAllocation = new Allocation();
    }

    public void initNewAllocation1() {
        newAllocation = new Allocation();
    }

    public void initNewAllocation2() {
        newAllocation = new Allocation();
    }

    public  void register() throws Exception {


        try {

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

    public  void register1() throws Exception {
        try {
            allocationRegistration.register(newAllocation1);
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Registration successful");
            facesContext.addMessage(null, m);
            initNewAllocation1();
        }
        catch (Exception e){
            String errorMessage = getRootErrorMessage(e);
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Registration unsuccessful");
            facesContext.addMessage(null, m);

        }

    }
    public  void register2() throws Exception {
        try {
            allocationRegistration.register(newAllocation2);
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Registration successful");
            facesContext.addMessage(null, m);
            initNewAllocation2();
        }
        catch (Exception e){
            String errorMessage = getRootErrorMessage(e);
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Registration unsuccessful");
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
