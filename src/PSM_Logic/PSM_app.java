package PSM_Logic;

import testPSM.InterfaceFacade;


public class PSM_app {

	public static void main(String[] args) {
//      Calendar now = new GregorianCalendar();
//      now.set(2008, 3, 15, 13, 29);
//      date = now.getTime();
//     
	   	appController app = new appController();
	   	InterfaceFacade fac = new InterfaceFacade();
    	fac.initiate(new LogicFacade(app.dataFacade));
    	app.getIC().setFacade(fac);
	   	app.myMain();
	}

}
