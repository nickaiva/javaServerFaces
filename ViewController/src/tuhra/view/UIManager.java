package tuhra.view;

import java.io.Serializable;

public class UIManager implements Serializable {
    
  private long _editEmployeeId;
  public enum Screen {EMPLOYEE_SEARCH, DEPARTMENT_TREE}
  private Screen _searchScreenFocus = Screen.EMPLOYEE_SEARCH;
     
    public UIManager() {
        super();
    }
    
    /**
     * @param _editEmployeeId can be null!
     */
    public void setEditEmployeeId(long _editEmployeeId) {
        this._editEmployeeId = _editEmployeeId;
    }

    public long getEditEmployeeId() {
        return _editEmployeeId;
    }

    
    /**
     * Set the searchScreenFocus flag from a text
     * version of the screen name.
     * @param focus String matching the enumeration value
    */
    public void setSearchScreenFocus(String focus) {
         this._searchScreenFocus = Screen.valueOf(focus);
    }
    /*** @param focus
     * Set the searchScreenFocus flag from the enum value
    */
     public void setSearchScreenFocus(UIManager.Screen focus){
         this._searchScreenFocus = focus;
     }
    /**
    * Return the searchScreenFocus as the enum constant.
    * @return
   */ 
    public UIManager.Screen getSearchScreenFocus() {
         return _searchScreenFocus;
     }
}
