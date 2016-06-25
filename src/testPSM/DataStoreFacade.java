/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testPSM;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 *
 * @author clarkep
 */
public class DataStoreFacade {
	private String correctUser;
	private String correctPass;
	private String resultString = "";
	
	private boolean isConnected;
	
	public ArrayList<Integer> courses = new ArrayList<Integer>();
	public TreeMap<Integer, String> defSub = new TreeMap<Integer, String>();
    public TreeMap<Integer, String> defSemester = new TreeMap<Integer, String>();
    public TreeMap<Integer, String> defCourseName = new TreeMap<Integer, String>();
    public TreeMap<Integer, String> defCourseStart = new TreeMap<Integer, String>();
    public TreeMap<Integer, String> defCourseEnd = new TreeMap<Integer, String>();
    public TreeMap<Integer, String> defMonStart = new TreeMap<Integer, String>();
    public TreeMap<Integer, String> defMonEnd = new TreeMap<Integer, String>();
    public TreeMap<Integer, String> defTueStart = new TreeMap<Integer, String>();
    public TreeMap<Integer, String> defTueEnd = new TreeMap<Integer, String>();
    public TreeMap<Integer, String> defWedStart = new TreeMap<Integer, String>();
    public TreeMap<Integer, String> defWedEnd = new TreeMap<Integer, String>();
    public TreeMap<Integer, String> defThuStart = new TreeMap<Integer, String>();
    public TreeMap<Integer, String> defThuEnd = new TreeMap<Integer, String>();
    public TreeMap<Integer, String> defFriStart = new TreeMap<Integer, String>();
    public TreeMap<Integer, String> defFriEnd = new TreeMap<Integer, String>();
    public TreeMap<Integer, String> defSatStart = new TreeMap<Integer, String>();
    public TreeMap<Integer, String> defSatEnd = new TreeMap<Integer, String>();
    
	public DataStoreFacade() {
		correctUser = "user";
		correctPass = "pw";
		isConnected = false;
	}

	public void testHelper(int courseID, String courseSubj,
			String courseName, String semester, String startDate, String endDate,
			String startMon, String endMon, String startTue, String endTue,
			String startWed, String endWed, String startThu, String endThu,
			String startFri, String endFri, String startSat, String endSat){
		courses.add(courseID);
		defSub.put(courseID, courseSubj);
		defCourseName.put(courseID, courseName);
		defSemester.put(courseID, semester);
		defCourseStart.put(courseID, startDate);
		defCourseEnd.put(courseID, endDate);
		defMonStart.put(courseID, startMon);
		defMonEnd.put(courseID, endMon);
		defTueStart.put(courseID, startTue);
		defTueEnd.put(courseID, endTue);
		defWedStart.put(courseID, startWed);
		defWedEnd.put(courseID, endWed);
		defThuStart.put(courseID, startThu);
		defThuEnd.put(courseID, endThu);
		defFriStart.put(courseID, startFri);
		defFriEnd.put(courseID, endFri);
		defSatStart.put(courseID, startSat);
		defSatEnd.put(courseID, endSat);
	}
	public void setString(String s){
		resultString = s;
	}
	public String fetchCourses() {
		//return dbCon.fetchCourses();
		return resultString;
	}
	
	public int connect(String user, String pw) {
		if(correctUser.equals(user) && correctPass.equals(pw)){
			isConnected = true;
			return 0;
		}
		else{
			isConnected = false;
			return -1;
		}
	}

	
	public int disconnect() {
		isConnected = false;
		return 0;
	}

	
	public ArrayList<String> getEndDates() {
		ArrayList<String> endDates = new ArrayList<String>();
		endDates.addAll(defCourseEnd.values());
		return endDates;
	}

	
	public ArrayList<Integer> getCourses() {
		return courses;
	}

	
	public String fetchCourseSubj(int courseID) {
		return defSub.get(courseID);
	}

	
	public String fetchCourseName(int courseID) {
		return defCourseName.get(courseID);
	}

	
	public String fetchCourseSemester(int courseID) {
		return defSemester.get(courseID);
	}

	
	public String fetchCourseStart(int courseID) {
		return defCourseStart.get(courseID);
	}

	
	public String fetchCourseEnd(int courseID) {
		return defCourseEnd.get(courseID);
	}

	
	public String fetchStartMon(int courseID) {
		return defMonStart.get(courseID);
	}

	
	public String fetchEndMon(int courseID) {
		return defMonEnd.get(courseID);
	}

	
	public String fetchStartTue(int courseID) {
		return defTueStart.get(courseID);
	}

	
	public String fetchEndTue(int courseID) {
		return defTueEnd.get(courseID);
	}

	
	public String fetchStartWed(int courseID) {
		return defWedStart.get(courseID);
	}

	
	public String fetchEndWed(int courseID) {
		return defWedEnd.get(courseID);
	}

	
	public String fetchStartThu(int courseID) {
		return defThuStart.get(courseID);
	}

	
	public String fetchEndThu(int courseID) {
		return defThuEnd.get(courseID);
	}

	
	public String fetchStartFri(int courseID) {
		return defFriStart.get(courseID);
	}

	
	public String fetchEndFri(int courseID) {
		return defFriEnd.get(courseID);
	}

	
	public String fetchStartSat(int courseID) {
		return defSatStart.get(courseID);
	}

	
	public String fetchEndSat(int courseID) {
		return defSatEnd.get(courseID);
	}

	
	public int storeClassInfo(int courseID, String courseSubj,
			String courseName, String semester) {
		courses.add(courseID);
		defSub.put(courseID, courseSubj);
		defCourseName.put(courseID, courseName);
		defSemester.put(courseID, semester);
		return 0;
	}

	
	public int storeClassSched(int courseID, String startDate, String endDate,
			String startMon, String endMon, String startTue, String endTue,
			String startWed, String endWed, String startThu, String endThu,
			String startFri, String endFri, String startSat, String endSat) {
		if(courses.contains(courseID)){
			defCourseStart.put(courseID, startDate);
			defCourseEnd.put(courseID, endDate);
			defMonStart.put(courseID, startMon);
			defMonEnd.put(courseID, endMon);
			defTueStart.put(courseID, startTue);
			defTueEnd.put(courseID, endTue);
			defWedStart.put(courseID, startWed);
			defWedEnd.put(courseID, endWed);
			defThuStart.put(courseID, startThu);
			defThuEnd.put(courseID, endThu);
			defFriStart.put(courseID, startFri);
			defFriEnd.put(courseID, endFri);
			defSatStart.put(courseID, startSat);
			defSatEnd.put(courseID, endSat);
			return 0;
		}
		return -1;
	}

	
	public void clearDatabase() {
		if(isConnected){
			courses.clear();
			defSub.clear();
			defCourseName.clear();
			defSemester.clear();
			defCourseStart.clear();
			defCourseEnd.clear();
			defMonStart.clear();
			defMonEnd.clear();
			defTueStart.clear();
			defTueEnd.clear();
			defWedStart.clear();
			defWedEnd.clear();
			defThuStart.clear();
			defThuEnd.clear();
			defFriStart.clear();
			defFriEnd.clear();
			defSatStart.clear();
			defSatEnd.clear();
		}
	}
	
	
}
		
