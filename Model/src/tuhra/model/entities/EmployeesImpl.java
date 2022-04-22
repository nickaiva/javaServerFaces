package tuhra.model.entities;

import oracle.jbo.Key;
import oracle.jbo.RowIterator;
import oracle.jbo.RowSet;
import oracle.jbo.domain.DBSequence;
import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityDefImpl;

import oracle.jbo.server.TransactionEvent;

import tuhra.model.framework.TuhraEntityImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sun Feb 07 17:08:17 EET 2010
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class EmployeesImpl extends TuhraEntityImpl {
    private static EntityDefImpl mDefinitionObject;

    /**
     * Add locking logic here.
     */
    public void lock() {
        super.lock();
    }

    /**
     * Custom DML update/insert/delete logic here.
     * @param operation the operation type
     * @param e the transaction event
     */
    protected void doDML(int operation, TransactionEvent e) {
        if (operation == DML_UPDATE) {
            String oldJobId = (String)getPostedAttribute(JOBID);
            if (!getJobId().equals(oldJobId)) {
                //Get the set of JobHistory rows
                RowSet pastJobs = (RowSet)this.getJobHistory();
                Date histStartDate;
                if (pastJobs.hasNext()) {
                    JobHistoryImpl row = (JobHistoryImpl)pastJobs.next();
                    histStartDate = row.getEndDate();
                } else {
                    //No history rows - fall back to the hiredate
                    histStartDate = getHireDate();
                }
                //You now have everything to create the JobHistory row
                JobHistoryImpl newRow = (JobHistoryImpl)pastJobs.createRow();
                newRow.setJobId(oldJobId);
                // the department may have been changed as part
                //of the same transaction so use the old version
                newRow.setDepartmentId((Number)getPostedAttribute(DEPARTMENTID));
                newRow.setStartDate(histStartDate);
                newRow.setEndDate(new Date(Date.getCurrentDate()));
                //And add the new row to the history rowset
                pastJobs.insertRow(newRow);
            }
            //Remember to do the update to Employees
            super.doDML(operation, e);

        } else {
            super.doDML(operation, e);
        }
    }

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
     */
    public enum AttributesEnum {
        EmployeeId {
            public Object get(EmployeesImpl obj) {
                return obj.getEmployeeId();
            }

            public void put(EmployeesImpl obj, Object value) {
                obj.setEmployeeId((DBSequence)value);
            }
        }
        ,
        FirstName {
            public Object get(EmployeesImpl obj) {
                return obj.getFirstName();
            }

            public void put(EmployeesImpl obj, Object value) {
                obj.setFirstName((String)value);
            }
        }
        ,
        LastName {
            public Object get(EmployeesImpl obj) {
                return obj.getLastName();
            }

            public void put(EmployeesImpl obj, Object value) {
                obj.setLastName((String)value);
            }
        }
        ,
        Email {
            public Object get(EmployeesImpl obj) {
                return obj.getEmail();
            }

            public void put(EmployeesImpl obj, Object value) {
                obj.setEmail((String)value);
            }
        }
        ,
        PhoneNumber {
            public Object get(EmployeesImpl obj) {
                return obj.getPhoneNumber();
            }

            public void put(EmployeesImpl obj, Object value) {
                obj.setPhoneNumber((String)value);
            }
        }
        ,
        HireDate {
            public Object get(EmployeesImpl obj) {
                return obj.getHireDate();
            }

            public void put(EmployeesImpl obj, Object value) {
                obj.setHireDate((Date)value);
            }
        }
        ,
        JobId {
            public Object get(EmployeesImpl obj) {
                return obj.getJobId();
            }

            public void put(EmployeesImpl obj, Object value) {
                obj.setJobId((String)value);
            }
        }
        ,
        Salary {
            public Object get(EmployeesImpl obj) {
                return obj.getSalary();
            }

            public void put(EmployeesImpl obj, Object value) {
                obj.setSalary((Number)value);
            }
        }
        ,
        CommissionPct {
            public Object get(EmployeesImpl obj) {
                return obj.getCommissionPct();
            }

            public void put(EmployeesImpl obj, Object value) {
                obj.setCommissionPct((Number)value);
            }
        }
        ,
        ManagerId {
            public Object get(EmployeesImpl obj) {
                return obj.getManagerId();
            }

            public void put(EmployeesImpl obj, Object value) {
                obj.setManagerId((Number)value);
            }
        }
        ,
        DepartmentId {
            public Object get(EmployeesImpl obj) {
                return obj.getDepartmentId();
            }

            public void put(EmployeesImpl obj, Object value) {
                obj.setDepartmentId((Number)value);
            }
        }
        ,
        CreatedBy {
            public Object get(EmployeesImpl obj) {
                return obj.getCreatedBy();
            }

            public void put(EmployeesImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        CreatedDate {
            public Object get(EmployeesImpl obj) {
                return obj.getCreatedDate();
            }

            public void put(EmployeesImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        ModifiedBy {
            public Object get(EmployeesImpl obj) {
                return obj.getModifiedBy();
            }

            public void put(EmployeesImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        ModifiedDate {
            public Object get(EmployeesImpl obj) {
                return obj.getModifiedDate();
            }

            public void put(EmployeesImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        Departments {
            public Object get(EmployeesImpl obj) {
                return obj.getDepartments();
            }

            public void put(EmployeesImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        Employees {
            public Object get(EmployeesImpl obj) {
                return obj.getEmployees();
            }

            public void put(EmployeesImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        ManagerIdEmployees {
            public Object get(EmployeesImpl obj) {
                return obj.getManagerIdEmployees();
            }

            public void put(EmployeesImpl obj, Object value) {
                obj.setManagerIdEmployees((EmployeesImpl)value);
            }
        }
        ,
        Departments1 {
            public Object get(EmployeesImpl obj) {
                return obj.getDepartments1();
            }

            public void put(EmployeesImpl obj, Object value) {
                obj.setDepartments1((TuhraEntityImpl)value);
            }
        }
        ,
        Jobs {
            public Object get(EmployeesImpl obj) {
                return obj.getJobs();
            }

            public void put(EmployeesImpl obj, Object value) {
                obj.setJobs((TuhraEntityImpl)value);
            }
        }
        ,
        JobHistory {
            public Object get(EmployeesImpl obj) {
                return obj.getJobHistory();
            }

            public void put(EmployeesImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        Biographies {
            public Object get(EmployeesImpl obj) {
                return obj.getBiographies();
            }

            public void put(EmployeesImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        EmployeeImageUsages {
            public Object get(EmployeesImpl obj) {
                return obj.getEmployeeImageUsages();
            }

            public void put(EmployeesImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        SalaryValidatorAccessor {
            public Object get(EmployeesImpl obj) {
                return obj.getSalaryValidatorAccessor();
            }

            public void put(EmployeesImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static int firstIndex = 0;

        public abstract Object get(EmployeesImpl object);

        public abstract void put(EmployeesImpl object, Object value);

        public int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        public static int firstIndex() {
            return firstIndex;
        }

        public static int count() {
            return AttributesEnum.firstIndex() +
                AttributesEnum.staticValues().length;
        }

        public static AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }


    public static final int EMPLOYEEID = AttributesEnum.EmployeeId.index();
    public static final int FIRSTNAME = AttributesEnum.FirstName.index();
    public static final int LASTNAME = AttributesEnum.LastName.index();
    public static final int EMAIL = AttributesEnum.Email.index();
    public static final int PHONENUMBER = AttributesEnum.PhoneNumber.index();
    public static final int HIREDATE = AttributesEnum.HireDate.index();
    public static final int JOBID = AttributesEnum.JobId.index();
    public static final int SALARY = AttributesEnum.Salary.index();
    public static final int COMMISSIONPCT = AttributesEnum.CommissionPct.index();
    public static final int MANAGERID = AttributesEnum.ManagerId.index();
    public static final int DEPARTMENTID = AttributesEnum.DepartmentId.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int MODIFIEDBY = AttributesEnum.ModifiedBy.index();
    public static final int MODIFIEDDATE = AttributesEnum.ModifiedDate.index();
    public static final int DEPARTMENTS = AttributesEnum.Departments.index();
    public static final int EMPLOYEES = AttributesEnum.Employees.index();
    public static final int MANAGERIDEMPLOYEES = AttributesEnum.ManagerIdEmployees.index();
    public static final int DEPARTMENTS1 = AttributesEnum.Departments1.index();
    public static final int JOBS = AttributesEnum.Jobs.index();
    public static final int JOBHISTORY = AttributesEnum.JobHistory.index();
    public static final int BIOGRAPHIES = AttributesEnum.Biographies.index();
    public static final int EMPLOYEEIMAGEUSAGES = AttributesEnum.EmployeeImageUsages.index();
    public static final int SALARYVALIDATORACCESSOR = AttributesEnum.SalaryValidatorAccessor.index();

    /**
     * This is the default constructor (do not remove).
     */
    public EmployeesImpl() {
    }


    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        if (mDefinitionObject == null) {
            mDefinitionObject = EntityDefImpl.findDefObject("tuhra.model.entities.Employees");
        }
        return mDefinitionObject;
    }

    /**
     * Gets the attribute value for EmployeeId, using the alias name EmployeeId.
     * @return the EmployeeId
     */
    public DBSequence getEmployeeId() {
        return (DBSequence)getAttributeInternal(EMPLOYEEID);
    }

    /**
     * Sets <code>value</code> as the attribute value for EmployeeId.
     * @param value value to set the EmployeeId
     */
    public void setEmployeeId(DBSequence value) {
        setAttributeInternal(EMPLOYEEID, value);
    }

    /**
     * Gets the attribute value for FirstName, using the alias name FirstName.
     * @return the FirstName
     */
    public String getFirstName() {
        return (String)getAttributeInternal(FIRSTNAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for FirstName.
     * @param value value to set the FirstName
     */
    public void setFirstName(String value) {
        setAttributeInternal(FIRSTNAME, value);
    }

    /**
     * Gets the attribute value for LastName, using the alias name LastName.
     * @return the LastName
     */
    public String getLastName() {
        return (String)getAttributeInternal(LASTNAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for LastName.
     * @param value value to set the LastName
     */
    public void setLastName(String value) {
        setAttributeInternal(LASTNAME, value);
    }

    /**
     * Gets the attribute value for Email, using the alias name Email.
     * @return the Email
     */
    public String getEmail() {
        return (String)getAttributeInternal(EMAIL);
    }

    /**
     * Sets <code>value</code> as the attribute value for Email.
     * @param value value to set the Email
     */
    public void setEmail(String value) {
        setAttributeInternal(EMAIL, value);
    }

    /**
     * Gets the attribute value for PhoneNumber, using the alias name PhoneNumber.
     * @return the PhoneNumber
     */
    public String getPhoneNumber() {
        return (String)getAttributeInternal(PHONENUMBER);
    }

    /**
     * Sets <code>value</code> as the attribute value for PhoneNumber.
     * @param value value to set the PhoneNumber
     */
    public void setPhoneNumber(String value) {
        setAttributeInternal(PHONENUMBER, value);
    }

    /**
     * Gets the attribute value for HireDate, using the alias name HireDate.
     * @return the HireDate
     */
    public Date getHireDate() {
        return (Date)getAttributeInternal(HIREDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for HireDate.
     * @param value value to set the HireDate
     */
    public void setHireDate(Date value) {
        setAttributeInternal(HIREDATE, value);
    }

    /**
     * Gets the attribute value for JobId, using the alias name JobId.
     * @return the JobId
     */
    public String getJobId() {
        return (String)getAttributeInternal(JOBID);
    }

    /**
     * Sets <code>value</code> as the attribute value for JobId.
     * @param value value to set the JobId
     */
    public void setJobId(String value) {
        setAttributeInternal(JOBID, value);
    }

    /**
     * Gets the attribute value for Salary, using the alias name Salary.
     * @return the Salary
     */
    public Number getSalary() {
        return (Number)getAttributeInternal(SALARY);
    }

    /**
     * Sets <code>value</code> as the attribute value for Salary.
     * @param value value to set the Salary
     */
    public void setSalary(Number value) {
        setAttributeInternal(SALARY, value);
    }

    /**
     * Gets the attribute value for CommissionPct, using the alias name CommissionPct.
     * @return the CommissionPct
     */
    public Number getCommissionPct() {
        return (Number)getAttributeInternal(COMMISSIONPCT);
    }

    /**
     * Sets <code>value</code> as the attribute value for CommissionPct.
     * @param value value to set the CommissionPct
     */
    public void setCommissionPct(Number value) {
        setAttributeInternal(COMMISSIONPCT, value);
    }

    /**
     * Gets the attribute value for ManagerId, using the alias name ManagerId.
     * @return the ManagerId
     */
    public Number getManagerId() {
        return (Number)getAttributeInternal(MANAGERID);
    }

    /**
     * Sets <code>value</code> as the attribute value for ManagerId.
     * @param value value to set the ManagerId
     */
    public void setManagerId(Number value) {
        setAttributeInternal(MANAGERID, value);
    }

    /**
     * Gets the attribute value for DepartmentId, using the alias name DepartmentId.
     * @return the DepartmentId
     */
    public Number getDepartmentId() {
        return (Number)getAttributeInternal(DEPARTMENTID);
    }

    /**
     * Sets <code>value</code> as the attribute value for DepartmentId.
     * @param value value to set the DepartmentId
     */
    public void setDepartmentId(Number value) {

        // Define some variable names to make the code more readable
        final Number changeToDepartment = value;
        final Number sales = new Number(80);

        // First get the current value of the department so we can
        // do something only if this value *was* Sales.
        Number changeFromDepartment = getDepartmentId();
        // Set the DepartmentId as usual.
        setAttributeInternal(DEPARTMENTID, value);
        // If changing from Sales to something else then
        // null out Commission. Check for null first to avoid an exception.
        if (!(changeFromDepartment == null)) {
            if (changeFromDepartment.equals(sales) &&
                !changeToDepartment.equals(sales)) {
                setCommissionPct(null);
            } else {
                if (!changeFromDepartment.equals(sales) &&
                    changeToDepartment.equals(sales)) {
                    Number originalCommission =
                        (Number)this.getPostedAttribute(COMMISSIONPCT);
                    if (originalCommission == null) {
                        originalCommission = new Number(0);
                    }
                    setCommissionPct(originalCommission);
                }
            }
        }

    }

    /**
     * Gets the attribute value for CreatedBy, using the alias name CreatedBy.
     * @return the CreatedBy
     */
    public String getCreatedBy() {
        return (String)getAttributeInternal(CREATEDBY);
    }

    /**
     * Gets the attribute value for CreatedDate, using the alias name CreatedDate.
     * @return the CreatedDate
     */
    public Date getCreatedDate() {
        return (Date)getAttributeInternal(CREATEDDATE);
    }

    /**
     * Gets the attribute value for ModifiedBy, using the alias name ModifiedBy.
     * @return the ModifiedBy
     */
    public String getModifiedBy() {
        return (String)getAttributeInternal(MODIFIEDBY);
    }

    /**
     * Gets the attribute value for ModifiedDate, using the alias name ModifiedDate.
     * @return the ModifiedDate
     */
    public Date getModifiedDate() {
        return (Date)getAttributeInternal(MODIFIEDDATE);
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
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getDepartments() {
        return (RowIterator)getAttributeInternal(DEPARTMENTS);
    }

    /**
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getEmployees() {
        return (RowIterator)getAttributeInternal(EMPLOYEES);
    }

    /**
     * @return the associated entity EmployeesImpl.
     */
    public EmployeesImpl getManagerIdEmployees() {
        return (EmployeesImpl)getAttributeInternal(MANAGERIDEMPLOYEES);
    }

    /**
     * Sets <code>value</code> as the associated entity EmployeesImpl.
     */
    public void setManagerIdEmployees(EmployeesImpl value) {
        setAttributeInternal(MANAGERIDEMPLOYEES, value);
    }

    /**
     * @return the associated entity tuhra.model.framework.TuhraEntityImpl.
     */
    public TuhraEntityImpl getDepartments1() {
        return (TuhraEntityImpl)getAttributeInternal(DEPARTMENTS1);
    }

    /**
     * Sets <code>value</code> as the associated entity tuhra.model.framework.TuhraEntityImpl.
     */
    public void setDepartments1(TuhraEntityImpl value) {
        setAttributeInternal(DEPARTMENTS1, value);
    }

    /**
     * @return the associated entity tuhra.model.framework.TuhraEntityImpl.
     */
    public TuhraEntityImpl getJobs() {
        return (TuhraEntityImpl)getAttributeInternal(JOBS);
    }

    /**
     * Sets <code>value</code> as the associated entity tuhra.model.framework.TuhraEntityImpl.
     */
    public void setJobs(TuhraEntityImpl value) {
        setAttributeInternal(JOBS, value);
    }

    /**
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getJobHistory() {
        return (RowIterator)getAttributeInternal(JOBHISTORY);
    }


    /**
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getBiographies() {
        return (RowIterator)getAttributeInternal(BIOGRAPHIES);
    }

    /**
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getEmployeeImageUsages() {
        return (RowIterator)getAttributeInternal(EMPLOYEEIMAGEUSAGES);
    }

    /**
     * Gets the view accessor <code>RowSet</code> SalaryValidatorAccessor.
     */
    public RowSet getSalaryValidatorAccessor() {
        return (RowSet)getAttributeInternal(SALARYVALIDATORACCESSOR);
    }

    /**
     * @param employeeId key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(DBSequence employeeId) {
        return new Key(new Object[]{employeeId});
    }


}
