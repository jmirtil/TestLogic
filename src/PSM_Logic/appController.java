/*
 * ApplicationLogic.java
 *
 * Created on April 12, 2008, 11:03 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package PSM_Logic;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

import testPSM.DataStoreFacade;

/**
 *
 * @author lrizo002
 */
public class appController {
    
    private static final long TENMIN = 600000;
    
    private static int hr;
    private static int min;
    private static Calendar autoClear = new GregorianCalendar();
    private static Calendar setRun = new GregorianCalendar();
    private static Calendar calendar = new GregorianCalendar();
    private static Timer timer = new FutureTimer();
    private static Date date = new Date();
    private static Date date2 = new Date();
    
    public static String defSub = "";
    public static String defSemester = "";
    public static String defCourseName = "";
    public static String defCourseStart = "";
    public static String defCourseEnd = "";
    public static String defMonStart = "";
    public static String defMonEnd = "";
    public static String defTueStart = "";
    public static String defTueEnd = "";
    public static String defWedStart = "";
    public static String defWedEnd = "";
    public static String defThuStart = "";
    public static String defThuEnd = "";
    public static String defFriStart = "";
    public static String defFriEnd = "";
    public static String defSatStart = "";
    public static String defSatEnd = "";
    
    private static String username;
    private static String password;
    private static boolean loggedin;
    private static boolean dataReceived = false;
    private static boolean edSchedSel = false;
    public static boolean isEdSchedSel() {
		return edSchedSel;
	}

	public static boolean isSchedSetupSel() {
		return schedSetupSel;
	}

	public static boolean isLogoutSel() {
		return logoutSel;
	}


	private static boolean schedSetupSel = false;
    private static boolean logoutSel = false;
    
    private static int clearDate, clearMonth, clearYear;
 

	private static int counter = 0;
    
    public static DataStoreFacade dataFacade = new DataStoreFacade();
    private static InterfaceController ic = new InterfaceController();
    private static Authenticate auth = new Authenticate();
    private static int courseSel;
    private static long classEnded = 0;
       
    
    /** Creates a new instance of ApplicationLogic */
    public appController() {
        hr = min = 0;
    }
    
    /* Set to the stubs when testing*/
    public static void setDataStoreFacade(DataStoreFacade temp){
    	dataFacade = temp;
    }
    public static void setInterfaceController(InterfaceController temp){
    	ic = temp;
    }
    public static void setAuthenticate(Authenticate temp){
    	auth = temp;
    }
    public void appMainMenu(){    
        long newCurrentTime;
        while(!dataReceived)
        {
            dataReceived = ic.facade.menuDataRec();
            edSchedSel = ic.facade.editSchedSelected();
            schedSetupSel = ic.facade.InitSetupSelected();
            logoutSel = ic.facade.logoutSelected();
            //System.out.println("Class end time: " +classEnded);
            //System.out.println("Current time: " +System.currentTimeMillis());
                    
                    
            if(classEnded != 0 && System.currentTimeMillis() - classEnded >= TENMIN)
            {
              //System.out.println("EXIT");
            	return;	              
        	}
            
            sleep(500);
        }
        newCurrentTime = 0;
        ic.facade.setMenuDataRec(false);
        dataReceived = false;
        
       // db.disconnect();
	}
    public void myMain(){
    	appLogin();
    	if(loggedin){
    		ic.Initiate_MainMenu();
    		if(checkClear())
	        {
	            dataFacade.clearDatabase();
	        }
    		checkTimes();
	    	while(!logoutSel){
	    		appMainMenu();
		    	if(logoutSel)
		        {
		            // Logout 
		            auth.logout();
		            ic.Initiate_Logout();
		
		        }
		        else if(edSchedSel)
		        {
		            appEditSched();
		        }
		        else if(schedSetupSel)
		        {
		            setupSched();
		        }
	    	}
    	}
    }
    public void setUser(String user){
    	username = user;
    }
    public void setPassword(String pw){
    	password = pw;
    }
    public String getUser(){
    	return username;
    }
    public String getPass(){
    	return password;
    }
    public boolean getLoggedIn(){
    	return loggedin;
    }
    public static String fetchCourses(){
    	return dataFacade.fetchCourses();
    }
    public InterfaceController getIC(){
    	return ic;
    }
    public Calendar getSetRun(){
    	return setRun;
    }
    public static int getClearDate() {
 		return clearDate;
 	}

 	public static int getClearMonth() {
 		return clearMonth;
 	}

 	public static int getClearYear() {
 		return clearYear;
 	}

 	public int getCounter(){
 		return counter;
 	}
    public static void setupSched(){
    	ic.facade.launchInitial();
        //Initial Schedule Setup
        while(!ic.facade.schedDataRec())
        {
            dataReceived = ic.facade.schedDataRec();
            sleep(300);
        }
        dataReceived = false;
        ic.facade.setSchedDataRec(false);
        
        dataFacade.storeClassInfo(ic.facade.getNewCourseID(), ic.facade.getNewSub(), ic.facade.getNewCourseName(),ic.facade.getNewSemester());
        dataFacade.storeClassSched(ic.facade.getNewCourseID(), ic.facade.getNewCourseStart(), ic.facade.getNewCourseEnd(), 
                ic.facade.getNewMonStart(), ic.facade.getNewMonEnd(), ic.facade.getNewTueStart(), ic.facade.getNewTueEnd(), 
                ic.facade.getNewWedStart(), ic.facade.getNewWedEnd(), ic.facade.getNewThuStart(), ic.facade.getNewThuEnd(), 
                ic.facade.getNewFriStart(), ic.facade.getNewFriEnd(), ic.facade.getNewSatStart(), ic.facade.getNewSatEnd());

    }
    public static void appEditSched(){
    	 //Edit Schedule
        ic.Course_Select_Form();

        while(!dataReceived)
        {
            dataReceived = ic.facade.courseSelected();
            sleep(300);
         //   System.out.println("test");
        }

        ic.facade.setCourseSelected(false);
        dataReceived = false;

        courseSel = ic.facade.getSelection();
        getData(courseSel);
        
        ic.Pre_Filled_Form(courseSel,defSub,defCourseName,defSemester,defCourseStart,
                defCourseEnd,defMonStart,defMonEnd,defTueStart,defTueEnd,defWedStart,
                defWedEnd,defThuStart,defThuEnd,defFriStart,defFriEnd,defSatStart,defSatEnd);
        
        while(!dataReceived)
        {
            dataReceived = ic.facade.psDataRec(); 
            sleep(300);
        }
        
        dataReceived = false;
        ic.facade.setPsDataRec(false);

        //System.out.println("Save has been pressed" +ic.edSched.newMonStart);

        dataFacade.storeClassSched(ic.facade.getDefCourseID(), ic.facade.getpNewCourseStart(), ic.facade.getpNewCourseEnd(), 
                ic.facade.getpNewMonStart(), ic.facade.getpNewMonEnd(), ic.facade.getpNewTueStart(), ic.facade.getpNewTueEnd(), 
                ic.facade.getpNewWedStart(), ic.facade.getpNewWedEnd(), ic.facade.getpNewThuStart(), ic.facade.getpNewThuEnd(), 
                ic.facade.getpNewFriStart(), ic.facade.getpNewFriEnd(), ic.facade.getpNewSatStart(), ic.facade.getpNewSatEnd());


    }
    
    public static void appLogin(){
    	while(!loggedin)
        {           
            ic.Initiate_Login_Form();            
            
             do
             {
                 dataReceived = ic.facade.dataReceived();
                 sleep(300);
                 
             }while(!dataReceived);
             ic.facade.setLogDataRec(false);
             dataReceived = false;
             username = ic.facade.getUsername();
             password = ic.facade.getPassword();

             
             auth.setCredentials(username,password);
             if(auth.validate_Login()){
                 loggedin = true;
                 auth.logout();
                 dataFacade.connect(username,password);
             }
             
               
             if(!loggedin){
                 ic.Initiate_IncorrectLogin();
                 counter++;
                 while(!dataReceived)
                 {
                     dataReceived = ic.facade.getAck();
                     System.out.println("in");
                 }
                 dataReceived = false;
                 ic.facade.setAck(false);
                 
             }
             if(counter >= 3){
                
                 ic.passwordLock();
                 while(!dataReceived)
                 {
                     dataReceived = ic.facade.getAck();
                     
                 }
                 return;
             }
        }
    }
    public static boolean checkClear()
    {
        ArrayList<String> endDates = dataFacade.getEndDates();
        Calendar endCal = new GregorianCalendar();
        Calendar now = Calendar.getInstance();
        
        for(int i = 0; i < endDates.size(); i++)
        {
            dateParser(endDates.get(i));
            
            //System.out.println("Day : " +clearDate);
            //System.out.println("Month : " +clearMonth);
            //System.out.println("Year : " +clearYear);

            endCal.set(clearYear + 2000, clearMonth-1, clearDate);
            if(now.compareTo(endCal) <= 0)
               return false;
                
        }
        return true;
                
    }
            
    public static void checkTimes()
    {
        ArrayList<Integer> courseList = dataFacade.getCourses();
        
        Calendar tempC = new GregorianCalendar();
        int currentDay = tempC.get(tempC.DAY_OF_WEEK);
        tempC.setTimeInMillis(System.currentTimeMillis());
        //System.out.println("Curr Day: " +currentDay);
        Date fifteenMin;
        Date fiveMin;
        Date endClass;
        
        for(int i = 0; i < courseList.size(); i++)
        {
            boolean isNull = true;
            getData(courseList.get(i).intValue());
            Timer newTimer = new FutureTimer();
            
            if(currentDay == 2 && defMonEnd.compareTo("") != 0)
            {
                timerParser(defMonEnd);
                isNull = false;
            }
            else if(currentDay == 3 && defTueEnd.compareTo("") != 0)
            {
                timerParser(defTueEnd);
                isNull = false;
            }
            else if(currentDay == 4 && defWedEnd.compareTo("") != 0)
            {
                timerParser(defWedEnd);
                isNull = false;
            }
            else if(currentDay == 5 && defThuEnd.compareTo("") != 0)
            {
                timerParser(defThuEnd);
                isNull = false;
            }
            else if(currentDay == 6 && defFriEnd.compareTo("") != 0)
            {
                timerParser(defFriEnd);
                isNull = false;
            }
            
            else if(currentDay == 7 && defSatEnd.compareTo("") != 0)
            {
                
                timerParser(defSatEnd);
                isNull = false;
            }
            
            
            if(!isNull){
                fiveMin = get5BeforeEnd(hr, min);
                newTimer.schedule(popup5min, fiveMin);
                fifteenMin = get15BeforeEnd(hr, min);              
                newTimer.schedule(popup15min, fifteenMin);
                endClass = getEndTime(hr, min);
                newTimer.schedule(endofclass, endClass);
            }
        }   
       
    }
    
    public static void getData(int course)
    {
        defSub = dataFacade.fetchCourseSubj(course);
        defSemester = dataFacade.fetchCourseSemester(course);
        defCourseName = dataFacade.fetchCourseName(course);
        defCourseStart = dataFacade.fetchCourseStart(course);
        defCourseEnd = dataFacade.fetchCourseEnd(course);
        defMonStart = dataFacade.fetchStartMon(course);
        defMonEnd = dataFacade.fetchEndMon(course);
        defTueStart = dataFacade.fetchStartTue(course);
        defTueEnd = dataFacade.fetchEndTue(course);
        defWedStart = dataFacade.fetchStartWed(course);
        defWedEnd = dataFacade.fetchEndWed(course);
        defThuStart = dataFacade.fetchStartThu(course);
        defThuEnd = dataFacade.fetchEndThu(course);
        defFriStart = dataFacade.fetchStartFri(course);
        defFriEnd = dataFacade.fetchEndFri(course);
        defSatStart = dataFacade.fetchStartSat(course);
        defSatEnd = dataFacade.fetchEndSat(course);           
    }
    
    
    public static void sleep(int milli)
    {
          try { 
           Thread.sleep(milli);
        } catch (InterruptedException ex) {
           Logger.getLogger(appController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	
    public static void LogIn()
    {      
        if(dataFacade.connect(username,password) == 0)
            loggedin = true;
        else
            loggedin = false;        
    }
    
    public static DataStoreFacade getCon()
    {
        return dataFacade;
    }
    
    
    private static TimerTask dbClear = new TimerTask()
    {
        public void run()
        {
           dataFacade.clearDatabase();
        }
    };
    
    private static TimerTask popup15min = new TimerTask()
    {
        public void run()
        {
            ic.facade.FifteenMinWarning();
        }
    };
	
    private static TimerTask popup5min = new TimerTask()
    {
        public void run()
        {
            ic.facade.FiveMinWarning();
        }
    };
    
    
    private static TimerTask endofclass = new TimerTask()
    {
        public void run()
        {
            ic.facade.endClassWarning();
            classEnded = System.currentTimeMillis();
        }
    };
    
    
    private static TimerTask systemExit = new TimerTask()
    {
        public void run()
        {
            System.exit(0);
        }
    };
    
       
    public void setTime(int year, int month, int date, int hours, int mins)
    {
        setRun.set(year, month, date, hours, mins);
    }
    
    public Date getTime()
    {
        return setRun.getTime();
    }
    
    public static long getTimeMillis()
    {
        return setRun.getTimeInMillis();
    }
    
    public static void timerParser(String timer)
    {
        hr = Integer.parseInt(timer.substring(0,2));
        min = Integer.parseInt(timer.substring(3,5));
    }
    public static void dateParser(String timer)
    {
        
        clearMonth = Integer.parseInt(timer.substring(0,2));
        clearDate = Integer.parseInt(timer.substring(3,5));
        clearYear = Integer.parseInt(timer.substring(6,8));
    }
    
    public int returnHr()
    {
        return hr;
    }
    
    public int returnMin()
    {
        return min;
    }
    
    public static Date getEndTime(int hrs, int mins)
    {
        int years, months, dates, dayOfWeek;
        
        Calendar tempC = new GregorianCalendar();
        
        tempC.setTimeInMillis(System.currentTimeMillis());
        
        years = tempC.get(tempC.YEAR);
        months = tempC.get(tempC.MONTH);
        dates = tempC.get(tempC.DATE);
        dayOfWeek = tempC.get(tempC.DAY_OF_WEEK);
        tempC.set(years, months, dates, hrs, mins - 1, 1);
        // System.out.println(dayWeek);
        return tempC.getTime();
    }
    
    public static void setSemesterClear(int year, int month, int date, int hours, int mins)
    {
        autoClear.set(year, month, date, hours, mins);
        date2 = autoClear.getTime();
    }
    
    public Date getSemesterClear()
    {
        return autoClear.getTime();
    }
    
    public static Date get15BeforeEnd(int hrs, int mins)
    {
        int years, months, dates, dayOfWeek; 
        
        Calendar tempC = new GregorianCalendar();
        
        tempC.setTimeInMillis(System.currentTimeMillis());
        
        years = tempC.get(tempC.YEAR);
        months = tempC.get(tempC.MONTH);
        dates =  tempC.get(tempC.DATE);
        dayOfWeek = tempC.get(tempC.DAY_OF_WEEK);
        
        tempC.set(years, months, dates, hrs, mins - 15, 1);
        
        return tempC.getTime();
    }
    
    public static Date get5BeforeEnd(int hrs, int mins)
    {
        int years, months, dates, dayOfWeek;
        
        Calendar tempC = new GregorianCalendar();
        
        tempC.setTimeInMillis(System.currentTimeMillis());
        
        years = tempC.get(tempC.YEAR);
        months = tempC.get(tempC.MONTH);
        dates = tempC.get(tempC.DATE);
        dayOfWeek = tempC.get(tempC.DAY_OF_WEEK);
        tempC.set(years, months, dates, hrs, mins - 5, 1);
        // System.out.println(dayWeek);
        return tempC.getTime();
    }
    
    public void autoExit()
    {
        timer.schedule(systemExit, date);
    }
    
    public void autoClear()
    {
        timer.schedule(dbClear, date2);
    }
}
