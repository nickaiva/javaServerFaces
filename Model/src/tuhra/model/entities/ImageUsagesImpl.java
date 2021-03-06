package tuhra.model.entities;

import oracle.jbo.Key;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityDefImpl;

import oracle.jbo.server.TransactionEvent;

import tuhra.model.framework.TuhraEntityImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sat Feb 13 10:30:16 EET 2010
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class ImageUsagesImpl extends TuhraEntityImpl {
    private static EntityDefImpl mDefinitionObject;

    @Override
    public void postChanges(TransactionEvent e) {
        ImagesImpl image = getImages();
        if (STATUS_NEW == image.getPostState()) {
            image.postChanges(e);
        }
        super.postChanges(e);
    }

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
     */
    public enum AttributesEnum {
        ImageId {
            public Object get(ImageUsagesImpl obj) {
                return obj.getImageId();
            }

            public void put(ImageUsagesImpl obj, Object value) {
                obj.setImageId((Number)value);
            }
        }
        ,
        UsageType {
            public Object get(ImageUsagesImpl obj) {
                return obj.getUsageType();
            }

            public void put(ImageUsagesImpl obj, Object value) {
                obj.setUsageType((String)value);
            }
        }
        ,
        AssociatedId {
            public Object get(ImageUsagesImpl obj) {
                return obj.getAssociatedId();
            }

            public void put(ImageUsagesImpl obj, Object value) {
                obj.setAssociatedId((Number)value);
            }
        }
        ,
        DefaultImage {
            public Object get(ImageUsagesImpl obj) {
                return obj.getDefaultImage();
            }

            public void put(ImageUsagesImpl obj, Object value) {
                obj.setDefaultImage((String)value);
            }
        }
        ,
        Images {
            public Object get(ImageUsagesImpl obj) {
                return obj.getImages();
            }

            public void put(ImageUsagesImpl obj, Object value) {
                obj.setImages((ImagesImpl)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static int firstIndex = 0;

        public abstract Object get(ImageUsagesImpl object);

        public abstract void put(ImageUsagesImpl object, Object value);

        public int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        public static int firstIndex() {
            return firstIndex;
        }

        public static int count() {
            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
        }

        public static AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }
    public static final int IMAGEID = AttributesEnum.ImageId.index();
    public static final int USAGETYPE = AttributesEnum.UsageType.index();
    public static final int ASSOCIATEDID = AttributesEnum.AssociatedId.index();
    public static final int DEFAULTIMAGE = AttributesEnum.DefaultImage.index();
    public static final int IMAGES = AttributesEnum.Images.index();

    /**
     * This is the default constructor (do not remove).
     */
    public ImageUsagesImpl() {
    }

    /**
     * Gets the attribute value for ImageId, using the alias name ImageId.
     * @return the ImageId
     */
    public Number getImageId() {
        return (Number)getAttributeInternal(IMAGEID);
    }

    /**
     * Sets <code>value</code> as the attribute value for ImageId.
     * @param value value to set the ImageId
     */
    public void setImageId(Number value) {
        setAttributeInternal(IMAGEID, value);
    }

    /**
     * Gets the attribute value for UsageType, using the alias name UsageType.
     * @return the UsageType
     */
    public String getUsageType() {
        return (String)getAttributeInternal(USAGETYPE);
    }

    /**
     * Sets <code>value</code> as the attribute value for UsageType.
     * @param value value to set the UsageType
     */
    public void setUsageType(String value) {
        setAttributeInternal(USAGETYPE, value);
    }

    /**
     * Gets the attribute value for AssociatedId, using the alias name AssociatedId.
     * @return the AssociatedId
     */
    public Number getAssociatedId() {
        return (Number)getAttributeInternal(ASSOCIATEDID);
    }

    /**
     * Sets <code>value</code> as the attribute value for AssociatedId.
     * @param value value to set the AssociatedId
     */
    public void setAssociatedId(Number value) {
        setAttributeInternal(ASSOCIATEDID, value);
    }

    /**
     * Gets the attribute value for DefaultImage, using the alias name DefaultImage.
     * @return the DefaultImage
     */
    public String getDefaultImage() {
        return (String)getAttributeInternal(DEFAULTIMAGE);
    }

    /**
     * Sets <code>value</code> as the attribute value for DefaultImage.
     * @param value value to set the DefaultImage
     */
    public void setDefaultImage(String value) {
        setAttributeInternal(DEFAULTIMAGE, value);
    }

    /**
     * getAttrInvokeAccessor: generated method. Do not modify.
     * @param index the index identifying the attribute
     * @param attrDef the attribute

     * @return the attribute value
     * @throws Exception
     */
    protected Object getAttrInvokeAccessor(int index,
                                           AttributeDefImpl attrDef) throws Exception {
        if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count())) {
            return AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].get(this);
        }
        return super.getAttrInvokeAccessor(index, attrDef);
    }

    /**
     * setAttrInvokeAccessor: generated method. Do not modify.
     * @param index the index identifying the attribute
     * @param value the value to assign to the attribute
     * @param attrDef the attribute

     * @throws Exception
     */
    protected void setAttrInvokeAccessor(int index, Object value,
                                         AttributeDefImpl attrDef) throws Exception {
        if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count())) {
            AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].put(this, value);
            return;
        }
        super.setAttrInvokeAccessor(index, value, attrDef);
    }

    /**
     * @return the associated entity ImagesImpl.
     */
    public ImagesImpl getImages() {
        return (ImagesImpl)getAttributeInternal(IMAGES);
    }

    /**
     * Sets <code>value</code> as the associated entity ImagesImpl.
     */
    public void setImages(ImagesImpl value) {
        setAttributeInternal(IMAGES, value);
    }

    /**
     * @param imageId key constituent
     * @param usageType key constituent
     * @param associatedId key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(Number imageId, String usageType,
                                       Number associatedId) {
        return new Key(new Object[]{imageId, usageType, associatedId});
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        if (mDefinitionObject == null) {
            mDefinitionObject = EntityDefImpl.findDefObject("tuhra.model.entities.ImageUsages");
        }
        return mDefinitionObject;
    }
}
