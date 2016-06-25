/*
 * Authenticate.java
 *
 * Created on April 8, 2008, 3:25 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package PSM_Logic;

import testPSM.DataStoreFacade;


/**
 *
 * @author lrizo002
 */
public class Authenticate {
    
    protected String username;
    protected String password;
    DataStoreFacade db;
    /** Creates a new instance of Authenticate */
    public Authenticate(){
    	db = new DataStoreFacade();
    }
    public Authenticate(String user, String pw) {
        username = user;
        password = pw;
        db = new DataStoreFacade();
        
    }
    public void setCredentials(String user, String pass){
    	username = user;
    	password = pass;
    }
    public boolean validate_Login()
    {
        int state; 
        state = db.connect(username,password);          // connect to default database
        if(state == 0)
            return true;
        else
            return false;   
    }
    
    public boolean logout()
    {
        int state;
        state = db.disconnect();
        if(state == 0)
            return true;
        else
            return false;
    }
    
}
