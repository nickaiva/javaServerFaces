package tuhra.view.backing;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import oracle.jbo.domain.Number;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import javax.servlet.ServletContext;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.OperationBinding;

import org.apache.myfaces.trinidad.model.UploadedFile;

import tuhra.view.framework.TuhraBackingBean;

public class ImageUploadBean extends TuhraBackingBean implements Serializable  {
    
    public ImageUploadBean() {
        super();
    }
    private String _uploadedImageName = "/images/uploadPlaceholder.png";
    private UploadedFile _uploadedImageFile;

    public void setUploadedImageName(String _uploadedImageName) {
        this._uploadedImageName = _uploadedImageName;
    }

    public String getUploadedImageName() {
        return _uploadedImageName;
    }

    public void setUploadedImageFile(UploadedFile _uploadedImageFile) {
        this._uploadedImageFile = _uploadedImageFile;
    }

    public UploadedFile getUploadedImageFile() {
        return _uploadedImageFile;
    }

    public void fileUploadedListener(ValueChangeEvent valueChangeEvent) {
        UploadedFile file = (UploadedFile)valueChangeEvent.getNewValue();
        if (file != null) {
            String fileName = file.getFilename();
            setUploadedImageName("/images/" + fileName);
            copyFileToImagesDir(file);
            insertRows();
            }
    }

    private void copyFileToImagesDir(UploadedFile file) {
        
        ServletContext servletCtx = (ServletContext)
                         FacesContext.getCurrentInstance().getExternalContext().getContext();
        String imageDirPath = servletCtx.getRealPath("/images");
        //TODO use context param within web.xml instead of hard coding
        try {
            InputStream is = file.getInputStream();
            OutputStream os =
                new FileOutputStream(imageDirPath + "/" + file.getFilename());
            int readData;
            while ((readData = is.read()) != -1) {
                os.write(readData);
            }
            is.close();
            os.close();
        } catch (FileNotFoundException fnfe) {
            // TODO: Add catch code
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            // TODO: Add catch code
            ioe.printStackTrace();
        } 
        
    }

    private void insertRows() {
        
        AdfFacesContext afctx = AdfFacesContext.getCurrentInstance();
        Map<String, Object> pfParams = afctx.getPageFlowScope();
        Number empId = (Number)pfParams.get("currentEmpId");
        OperationBinding insImage =getBindings().getOperationBinding("createNewImageForEmployee");
        Map args = insImage.getParamsMap();
        args.put("employeeId", empId);
        args.put("imageName", _uploadedImageName);
        insImage.execute();
    }
}
