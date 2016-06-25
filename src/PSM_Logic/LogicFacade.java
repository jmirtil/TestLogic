/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PSM_Logic;

import testPSM.DataStoreFacade;


/**
 *
 * @author clarkep
 */
public class LogicFacade {
    private appController app;
    private Authenticate aut;
    private FutureTimer futureTime;
    private InterfaceController ic;
    
    public LogicFacade(DataStoreFacade dataFacade){
    	app = new appController();
    	app.setDataStoreFacade(dataFacade);
    	futureTime = new FutureTimer();
    	ic = new InterfaceController();
    }
    
    public static String fetchCourses(){
    	return appController.fetchCourses();
    }
}
