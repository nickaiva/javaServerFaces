package tuhra.model.queries.main.client;

import oracle.jbo.client.remote.ViewUsageImpl;
import oracle.jbo.domain.Number;

import tuhra.model.queries.main.common.AllEmployees;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sat Aug 07 12:01:08 EEST 2010
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class AllEmployeesClient extends ViewUsageImpl implements AllEmployees {
    /**
     * This is the default constructor (do not remove).
     */
    public AllEmployeesClient() {
    }

    public void queryEmployeeById(Number id) {
        Object _ret =
            getApplicationModuleProxy().riInvokeExportedMethod(this,"queryEmployeeById",new String [] {"oracle.jbo.domain.Number"},new Object[] {id});
        return;
    }
}
