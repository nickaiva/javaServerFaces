package tuhra.controller;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
/*SimpleCallbackHandler in C:\oracle\Middleware\modules\com.bea.core.weblogic.security.auth_1.0.0.0.jar*/
import weblogic.security.SimpleCallbackHandler;
/*C:\oracle\Middleware\wlserver_10.3\server\lib\weblogic.jar for Authentication and ServletAuthentication*/
import weblogic.security.services.Authentication;
import weblogic.servlet.security.ServletAuthentication;
import javax.security.auth.login.FailedLoginException;

import javax.security.auth.login.LoginException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandler {
    public LoginHandler() {
        super();
    }
    
    private String _username;
    private String _password;
    
    public String performLogin(){
    
        byte[] pw = _password.getBytes();
        FacesContext ctx = FacesContext.getCurrentInstance();
        HttpServletRequest request =(HttpServletRequest)ctx.getExternalContext().getRequest();
        CallbackHandler handler = new SimpleCallbackHandler(_username, pw);
        try{
            Subject mySubject = Authentication.login(handler);
            /*AuthenticatedSubject in wlthint3client.jar necessary*/
            ServletAuthentication.runAs(mySubject, request);
            String loginUrl = "/adfAuthentication?success_url=/faces" +
                                                                                    ctx.getViewRoot().getViewId();
            HttpServletResponse response =(HttpServletResponse)ctx.getExternalContext().getResponse();
            sendForward(request, response, loginUrl);
        } catch (FailedLoginException fle) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Incorrect Username or Password",
                            "An incorrect Username or Password" +
                            " was specified");
            ctx.addMessage(null, msg);
        } catch (LoginException le) {
                            reportUnexpectedLoginError("LoginException", le);
        }
      return null;
    }
    
    public String performLogout() {
            
            FacesContext ctx = FacesContext.getCurrentInstance();
            HttpServletRequest request =
                            (HttpServletRequest)ctx.getExternalContext().getRequest();
            HttpServletResponse response =
                            (HttpServletResponse)ctx.getExternalContext().getResponse();
            String logoutUrl =
                        "/adfAuthentication?logout=true&end_url=/faces/employeeSearch";
            sendForward(request, response, logoutUrl);
            return null;
    }

    private void sendForward(HttpServletRequest request,
                             HttpServletResponse response, String loginUrl) {
        
        FacesContext ctx = FacesContext.getCurrentInstance();
        RequestDispatcher dispatcher = request.getRequestDispatcher(loginUrl);


        try {
            dispatcher.forward(request, response);
        } catch (ServletException se) {
            reportUnexpectedLoginError("ServletException", se);
        } catch (IOException ie) {
            reportUnexpectedLoginError("IOException", ie);
        }
        ctx.responseComplete();
    }

    private void reportUnexpectedLoginError(String errType,
                                            Exception e){ 
        FacesMessage msg =
        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Unexpected Error During Login",
                                            "Unexpected Error during Login (" + errType +
                                            "), please consult logs for detail");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        e.printStackTrace();
    
    }

    public String getUsername() {
        return _username;
    }

    public String getPassword() {
        return _password;
    }

    public void setUsername(String _username) {
        this._username = _username;
    }

    public void setPassword(String _password) {
        this._password = _password;
    }
}
