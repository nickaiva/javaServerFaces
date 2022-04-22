package tuhra.view.backing;


import javax.faces.component.UIComponent;

import javax.faces.context.FacesContext;


import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.fragment.RichRegion;
import oracle.adf.view.rich.event.RegionNavigationEvent;

import oracle.adf.view.rich.render.ClientEvent;

import oracle.binding.AttributeBinding;
import oracle.binding.OperationBinding;

import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

import tuhra.view.framework.TuhraBackingBean;


public class EmployeeEditBean extends TuhraBackingBean {

    private String _imageTaskFlowId = "/WEB-INF/imageLOV-flow.xml#imageLOV-flow";
    private String _selectedTaskFlowId = "";
    
    public EmployeeEditBean() {
        super();
    }
    
    public void swapEmptyTaskFlow(ClientEvent event) {
        setSelectedTaskFlowId("");
        // If event delivery set to immediate="true",
        // short-circuit to renderResponse.
        // Forcing an empty taskflow releases the bindings and view port.
        Boolean immediate = (Boolean)event.getParameters().get("immediate");
        if (immediate != null && immediate) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.renderResponse();
        }
     }
    
        private void hidePopup( RichPopup  popup){
        
             FacesContext context =FacesContext.getCurrentInstance();
             String popId = popup.getClientId(context);
             Service.getRenderKitService(context,
                                         ExtendedRenderKitService.class).addScript(context,
                                                                                           "var popup = AdfPage.PAGE.findComponent('"
                                                                                           + popId +"');" +
             "popup.hide();");            
        }
    
    private RichPopup findParentPopup(UIComponent source) {
        
        UIComponent parent = source.getParent();
        while (parent != null && !(parent instanceof RichPopup)) {
            parent = parent.getParent();
        }
         return (RichPopup)parent;
    }
    
    public void navigationListener(RegionNavigationEvent regionNavigationEvent){
        
        String newViewId = regionNavigationEvent.getNewViewId();
        if (newViewId== null){
            RichRegion region = (RichRegion)regionNavigationEvent.getSource();
            RichPopup  popup =findParentPopup(region);
            if (popup !=null){
                hidePopup(popup);                      
            }
         }
            
    }

    public String lockIcon_action() {
        // Access the Locked attribute binding
        AttributeBinding lockedBinding = (AttributeBinding)getBindings().getControlBinding("Locked");
        Boolean locked = false;
        if (lockedBinding != null) {
            //Get the current value of the transient attr
            locked = (Boolean)lockedBinding.getInputValue();
        }
        //The attribute may be null if no detail record exists yet
        if (locked == null) {
            // Set a default value
            locked = true;
            // Create a Biographies record
            OperationBinding createBio = getBindings().getOperationBinding("CreateBio");
                if (createBio != null) {
                    createBio.execute();
                }
        }
        //Toggle the locked state
        lockedBinding.setInputValue(!locked); 
        return null;
    }

  

    public String getImageTaskFlowId() {
        return _imageTaskFlowId;
    }

    public String getDynamicTaskFlowId() {
      return _selectedTaskFlowId;
    }
    /*used to be private*/
    public void setSelectedTaskFlowId(String _selectedTaskFlowId) {
        this._selectedTaskFlowId = _selectedTaskFlowId;
    }

    public String getSelectedTaskFlowId() {
        return _selectedTaskFlowId;
    }
}
