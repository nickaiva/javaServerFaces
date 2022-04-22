package tuhra.view.framework;

import oracle.adf.model.BindingContext;

import oracle.binding.BindingContainer;


/**the purpose of this framework class is to
access the bindings programmatically.
 */
public abstract class TuhraBackingBean  {
    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }
}
