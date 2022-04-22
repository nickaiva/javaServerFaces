package tuhra.view.backing;

import java.io.Serializable;

import java.util.Map;

import oracle.adf.view.rich.datatransfer.DataFlavor;
import oracle.adf.view.rich.datatransfer.Transferable;
import oracle.adf.view.rich.dnd.DnDAction;
import oracle.adf.view.rich.event.DropEvent;

import oracle.adfinternal.view.faces.model.binding.FacesCtrlHierNodeBinding;

import oracle.binding.OperationBinding;

import oracle.jbo.domain.Number;

import org.apache.myfaces.trinidad.model.CollectionModel;
import org.apache.myfaces.trinidad.model.RowKeySet;

import tuhra.view.framework.TuhraBackingBean;


public class DefaultImageSelectionBean extends TuhraBackingBean implements Serializable{
    public DefaultImageSelectionBean() {
        super();
    }
    private String _selectedImage="/images/newDefaultPlaceholder.png";

    public void setSelectedImage(String _selectedImage) {
        this._selectedImage = _selectedImage;
    }

    public String getSelectedImage() {
        return _selectedImage;
    }

    public DnDAction dragAndDropHandler(DropEvent dropEvent) {
        
        FacesCtrlHierNodeBinding draggedNode = findDraggedNode(dropEvent);
        if (draggedNode != null) {
                 String imageName = (String)draggedNode.getAttribute("Image");
                 Number imageId = (Number)draggedNode.getAttribute("ImageId");
                 if (imageId != null) {
                     _selectedImage = imageName;
                     defineDefaultImage(imageId);
                     return DnDAction.COPY;
                  }
         }
         return DnDAction.NONE;
    }

    private void defineDefaultImage(Number imageId) {
        
        OperationBinding setDefault =
        getBindings().getOperationBinding("defineDefaultImage");
        Map args = setDefault.getParamsMap();
        args.put("newDefaultImageId", imageId);
        setDefault.execute();
    }

    private FacesCtrlHierNodeBinding findDraggedNode(DropEvent dropEvent) {
        
        FacesCtrlHierNodeBinding node = null;
         Transferable transferable = dropEvent.getTransferable();
         DataFlavor<RowKeySet> rowKeySetFlavor =
         DataFlavor.getDataFlavor(RowKeySet.class, "empImagesModel");
         RowKeySet rowKeySet = transferable.getData(rowKeySetFlavor);
         if (rowKeySet != null) {
                 CollectionModel dragModel = transferable.getData(CollectionModel.class);
                 if (dragModel != null) {
                     Object currKey = rowKeySet.iterator().next();
                     dragModel.setRowKey(currKey);
                     node = (FacesCtrlHierNodeBinding)dragModel.getRowData();
                 }
         }
         return node;
    }
}
